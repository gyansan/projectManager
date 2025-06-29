
//ID取得
const params = new URLSearchParams(location.search);
const projectId = params.get("project-id");

/*プロジェクト表示*/
async function displayProject(){
	const project = await getProjectApi(projectId);
	
	document.getElementById("projectName").textContent = project.projectName;
	document.getElementById("projectSummary").textContent = project.projectSummary;
	
}

/*スクリーンリスト表示*/
async function displayScreenList(){
	
	const screenList = await getScreenList();
	
	const tbody = document.getElementById("screenTableBody");
	tbody.innerHTML = "";
	
	screenList.forEach((screen)=> {
		const row = document.createElement("tr");
		row.dataset.id = screen.id;
		
		const nameCell = document.createElement("td");
		nameCell.textContent = screen.screenName;
		
		const summaryCell = document.createElement("td");
		summaryCell.textContent = screen.screenSummary;
		
		const actionCell = document.createElement("td");
		
		//編集ボタン
		const editButton = document.createElement("button");
		editButton.textContent = "編集";
		editButton.addEventListener("click",() => editScreen(screen.id));
		
		//削除ボタン
		const deleteButton = document.createElement("button");
		deleteButton.textContent = "削除";
		deleteButton.addEventListener("click", () => deleteScreen(screen.id));
		
		actionCell.appendChild(editButton);
		actionCell.appendChild(deleteButton);
		
		row.appendChild(nameCell);
		row.appendChild(summaryCell);
		row.appendChild(actionCell);
		tbody.appendChild(row);
	});
	
}

/*スクリーンリスト取得*/
async function getScreenList(){
	const screenList = await getScreenListApi(projectId);
	return screenList;
}

/*並べ替え処理*/
function sortOn(){
	const tbody = document.getElementById("screenTableBody");
	const attrName = "id";
	sortAdd(tbody, attrName, updateScreenSortOrder);
}

/*並び替えapi起動*/
async function updateScreenSortOrder(ids){
	const json = JSON.stringify({sortedIds:ids});
	console.log(json)
	await updateScreenSortOrderApi(projectId,json)
}

/*名前変更*/
async function editProjectName(){
	const newProjectName = document.getElementById("newProjectName").value;
	const json = JSON.stringify({projectName:newProjectName})

	await editProjectNameApi(projectId, json);

	closeEditProjectNameModal();
	await displayProject();
}

/*プロジェクト概要更新*/
async function editProjectSummary(){
	const newSummary = document.getElementById("projectSummary").value;
	const json = JSON.stringify({projectSummary:newSummary});
	
	await editProjectSummaryApi(projectId, json);
	
	updateSaveStatus(true);
}

/*プロジェクト概要保存状態の切替*/
function updateSaveStatus(isSaved){
	const statusElea = document.getElementById("summarySaveStatus");
	
	if(isSaved){
		statusElea.textContent = "保存済み";
	} else {
		statusElea.textContent = "未保存";
	};
}

/*編集ボタンが押された時の処理(遷移)*/
function editScreen(screenId){
	location.href = `../screen-detail/index.html?project-id=${projectId}&screen-id=${screenId}`;
}

/*スクリーン追加*/
async function addScreen(){
	//情報を取得してjsonに格納
	const addScreenForm = document.getElementById("addScreenForm");
	const formData = new FormData(addScreenForm);
	
	const json = JSON.stringify({
		screenName: formData.get("screenName"),
		screenSummary: formData.get("screenSummary")
	});
	
	//api呼び出し
	const screenId = await addScreenApi(projectId, json);
	console.log(screenId);
}




/*モーダル処理*/
function openEditProjectNameModal() {
  document.getElementById("editProjectNameModal").style.display = "block";
}

function closeEditProjectNameModal() {
  document.getElementById("editProjectNameModal").style.display = "none";
}

function openAddScreenModal(){
	document.getElementById("addScreenModal").style.display = "block";
}

function closeAddScreenModal(){
	document.getElementById("addScreenModal").style.display = "none";
}


/*関数呼び出し*/
window.addEventListener("load",displayProject);
window.addEventListener("load",displayScreenList);
window.addEventListener("load",sortOn);

document.getElementById("openEditProjectNameModal").addEventListener("click",openEditProjectNameModal);
document.getElementById("closeEditProjectNameModal").addEventListener("click",closeEditProjectNameModal);
document.getElementById("editProjectName").addEventListener("click",editProjectName);
document.getElementById("saveProjectSummary").addEventListener("click",editProjectSummary);
document.getElementById("projectSummary").addEventListener("input",()=> updateSaveStatus(false));

document.getElementById("openAddScreenModal").addEventListener("click",openAddScreenModal);
document.getElementById("closeAddScreenModal").addEventListener("click",closeAddScreenModal);
document.getElementById("addScreen").addEventListener("click",addScreen);
document.getElementById("")




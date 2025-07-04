
//ID取得
const params = new URLSearchParams(location.search);
const projectId = params.get("project-id");
const screenId = params.get("screen-id");

/*プロジェクト名表示*/
async function displayProjectName(){
	const project = await getProjectApi(projectId);
	document.getElementById("projectName").textContent = project.projectName;
}

/*スクリーン名と概要表示*/
async function displayScreen(){
	const screen = await getScreenApi(screenId)
	document.getElementById("screenName").textContent = screen.screenName;
	document.getElementById("screenSummary").textContent = screen.screenSummary;
}

/*機能一覧表示*/
async function displayFunctionList(){
	
	const functionList = await getFunctionListApi(screenId);
	
	const tbody = document.getElementById("functionTableBody");
	tbody.innerHTML = "";
	
	functionList.forEach((functionA)=> {
		const row = document.createElement("tr");
		row.dataset.id = functionA.id;
		
		const nameCell = document.createElement("td");
		nameCell.textContent = functionA.functionName;
		
		const summaryCell = document.createElement("td");
		summaryCell.textContent = functionA.functionSummary;
		
		const emplementedCell = document.createElement("td");
		//プルダウン作ってる
		const select = document.createElement("select");
		select.addEventListener("change", (e) => {
			const newValue = e.target.value;
			const functionId = functionA.id;
			updateFunctionEmplemented(functionId, newValue);
		});
	
		const option1 = document.createElement("option");
		option1.value = "true";
		option1.textContent = "実装済";
		
		const option2 = document.createElement("option");
		option2.value = "false";
		option2.textContent = "未実装";
		
		// 初期選択（functionA.emplemented が true なら option1 を選ぶ）
		if (functionA.emplemented) {
		  option1.selected = true;
		} else {
		  option2.selected = true;
		}
		
		select.appendChild(option1);
		select.appendChild(option2);
		emplementedCell.appendChild(select);
		
		const actionCell = document.createElement("td");
		
		const editButton = document.createElement("button");
		editButton.textContent = "編集";
		editButton.addEventListener("click",() => editFunction(functionA.id));
		
		const deleteButton = document.createElement("button");
		deleteButton.textContent = "削除";
		deleteButton.addEventListener("click", () => deleteFunction(functionA.id));
		
		actionCell.appendChild(editButton);
		actionCell.appendChild(deleteButton);
		
		row.appendChild(nameCell);
		row.appendChild(summaryCell);
		row.appendChild(emplementedCell);
		row.appendChild(actionCell);
		tbody.appendChild(row);
		
	});
	
}

/*機能追加*/
async function addFunction(){
	const addFunctionForm = document.getElementById("addFunctionForm");
	const formData = new FormData(addFunctionForm);
	
	const json = JSON.stringify({
		functionName: formData.get("functionName"),
		functionSummary: formData.get("functionSummary")
	});
	
	const functionId = await addFunctionApi(screenId, json);
	console.log(functionId);
}

/*機能の実装・未実装切替*/
async function updateFunctionEmplemented(functionId, newValue){
	const json = JSON.stringify({
		emplemented: newValue
	});
	
	updateFunctionEmplementedApi(functionId, json);
}


/*モーダル*/
function openAddFunctionModal() {
  document.getElementById("addFunctionModal").style.display = "block";
}

function closeAddFunctionModal() {
  document.getElementById("addFunctionModal").style.display = "none";
}








/*関数呼び出し*/
window.addEventListener("load",displayProjectName);
window.addEventListener("load",displayScreen);
window.addEventListener("load",displayFunctionList);

document.getElementById("openAddFunctionModal").addEventListener("click",openAddFunctionModal);
document.getElementById("closeAddFunctionModal").addEventListener("click",closeAddFunctionModal);
document.getElementById("addFunction").addEventListener("click",addFunction);

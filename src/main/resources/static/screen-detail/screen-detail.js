
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
	const screen = await getScreenApi(projectId,screenId)
	document.getElementById("screenName").textContent = screen.screenName;
	document.getElementById("screenSummary").textContent = screen.screenSummary;
}

/*機能追加*/
async function addFunction(){
	const addFunctionForm = document.getElementById("addFunctionForm");
	const formData = new FormData(addFunctionForm);
	
	const json = JSON.stringify({
		functionName: formData.get("functionName"),
		functionSummary: formData.get("functionSummary")
	});
	
	const functionId = await addFunctionApi(projectId, screenId, json);
	console.log(functionId);
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

document.getElementById("openAddFunctionModal").addEventListener("click",openAddFunctionModal);
document.getElementById("closeAddFunctionModal").addEventListener("click",closeAddFunctionModal);
document.getElementById("addFunction").addEventListener("click",addFunction);

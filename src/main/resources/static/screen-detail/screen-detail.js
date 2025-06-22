
//ID取得
const params = new URLSearchParams(location.search);
const projectId = params.get("project-id");
const screenId = params.get("screen-id");

/*プロジェクト名表示*/
async function displayProjectName(){
	const project = await getProjectApi(projectId);
	document.getElementById("projectName").textContent = project.projectName;
}

/*スクリーン名表示*/

















/*関数呼び出し*/
window.addEventListener("load",displayProjectName);


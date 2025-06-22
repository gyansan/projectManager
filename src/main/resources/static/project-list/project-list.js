

/*プロジェクト一覧表示*/
async function displayProjectList(){
	
	const projectList = await getProjectList();
	
	const tbody = document.getElementById("projectTableBody");
	tbody.innerHTML = "";
	
	projectList.forEach((project, index) => {
		const row = document.createElement("tr");
		
		const indexCell = document.createElement("td");
		indexCell.textContent = index + 1;
		
		const nameCell = document.createElement("td");
		nameCell.textContent = project.projectName;
		
		const actionCell = document.createElement("td");
		
		//編集ボタン
		const editButton = document.createElement("button");
		editButton.textContent = "編集";
		editButton.addEventListener("click",() => editProject(project.id));
		
		//削除ボタン
		const deleteButton = document.createElement("button");
		deleteButton.textContent = "削除";
		deleteButton.addEventListener("click", () => deleteProject(project.id));
		
		actionCell.appendChild(editButton);
		actionCell.appendChild(deleteButton);
		
		row.appendChild(indexCell);
		row.appendChild(nameCell);
		row.appendChild(actionCell);
		tbody.appendChild(row);
	});
}

/*プロジェクト一覧を取得*/
async function getProjectList(){
	const projectList = await getProjectListApi();
	return projectList;
}

/*追加処理*/
async function addProjectForm(){
	const name = document.getElementById("projectName").value;
	const json = JSON.stringify({projectName:name});
	const projectId = await addProjectApi(json);
	editProject(projectId);
}

/*削除処理*/
async function deleteProject(projectId){
	await deleteProjectApi(projectId);
	getProjectListAndDisplayTable();
}

/*編集ボタンが押された時の処理(遷移)*/
function editProject(projectId){
	location.href = `../project-detail/index.html?project-id=${projectId}`;
}


/*モーダル処理*/
function openAddProjectModal() {
  document.getElementById("addProjectModal").style.display = "block";
}

function closeAddProjectModal() {
  document.getElementById("addProjectModal").style.display = "none";
}


/*関数呼び出し*/
window.addEventListener("load",displayProjectList);
document.getElementById("openAddProjectModal").addEventListener("click", openAddProjectModal);
document.getElementById("closeAddProjectModal").addEventListener("click", closeAddProjectModal);
document.getElementById("addProject").addEventListener("click", addProjectForm);






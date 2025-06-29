
/*APIをまとめたスクリプトファイル*/

/*projectAPI*/
async function getProjectListApi(){
	const response = await fetch(`/api/projects`)
	return await response.json();
}

async function getProjectApi(projectId){
	const response = await fetch(`/api/projects/${projectId}`)
	return await response.json();
}

async function addProjectApi(json){
	const response = await fetch(`/api/projects`,{
		method:"POST",
		headers:{"Content-Type": `application/json`},
		body: json
	});
	const id = await response.json();
	return id;
}
	
async function deleteProjectApi(projectId){
	await fetch(`/api/projects/${projectId}`,{
		method:"DELETE"
	});
}

async function editProjectNameApi(projectId, json){
	await fetch(`/api/projects/${projectId}/name`,{
		method:"PATCH",
		headers:{"Content-Type":`application/json`},
		body: json
	});
}

async function editProjectSummaryApi(projectId, json){
	await fetch(`/api/projects/${projectId}/summary`,{
		method:"PATCH",
		headers:{"Content-Type":`application/json`},
		body: json
	});
}

/*screenAPI*/
async function addScreenApi(projectId, json){
	const response = await fetch(`/api/projects/${projectId}/screens`,{
		method:"POST",
		headers:{"Content-Type":`application/json`},
		body: json
	});
	const screenId = await response.json();
	return screenId;
}
async function getScreenListApi(projectId){
	const response = await fetch(`/api/projects/${projectId}/screens/list`)
	return await response.json();
}

async function updateScreenSortOrderApi(projectId,json){
	await fetch(`/api/projects/${projectId}/screens/sort-order`,{
		method:"PATCH",
		headers:{"Content-Type":"application/json"},
		body: json
	});
}

async function getScreenApi(projectId,screenId){
	const response = await fetch(`/api/projects/${projectId}/screens/${screenId}`)
	return await response.json();
}

/*functionAPI*/

async function addFunctionApi(projectId, screenId, json){
	console.log(json);
	const response = await fetch(`/api/projects/${projectId}/screens/${screenId}/functions`,{
		method:"POST",
		headers:{"Content-Type":`application/json`},
		body: json
	});
	const functionId = await response.json();
	return functionId;
}


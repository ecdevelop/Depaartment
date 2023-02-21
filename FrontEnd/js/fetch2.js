const api_url = 
      "http://localhost:8082/departments/";
  
// Defining async function
async function getapi(url) {
    
    // Storing response
    const response = await fetch(url);

    // Storing data in form of JSON
    var data = await response.json();
    console.log(data);
    if (response) {
        hideloader();
    }
    show(data);
}
// Calling that async function
getapi(api_url);
  
// Function to hide the loader
function hideloader() {
    document.getElementById('loading').style.display = 'none';
}
// Function to define innerHTML for HTML table
function show(data) {
    let tab = 
        `<tr>
          <th class="table-headers">Department ID</th>
          <th class="table-headers">Department Name</th>
          <th class="table-headers">Department Address</th>
          <th class="table-headers">Department Code</th>
         </tr>`;
    
    // Loop to access all rows 
    for (let r of data) {
        tab += `
        <tr> 
    <td>${r.departmentId} </td>
    <td>${r.departmentName}</td>
    <td>${r.departmentAddress}</td> 
    <td>${r.departmentCode}</td>          
        </tr>`;
    }
    // Setting innerHTML as tab variable
    document.getElementById("employees").innerHTML = tab;
}



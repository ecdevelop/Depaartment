
const obj = {
    name: "Spencer"
}
JSON.stringify(obj);

console.log(obj);


   var form = document.getElementById('form');

   form.addEventListener('submit', async event =>{
    event.preventDefault;

    const formData = new FormData(form);
    const data = Object.fromEntries(formData);
    console.log(data);
   
    //fetch post request 

    fetch("http://localhost:8082/departments/",{
    method: 'POST',
        body: JSON.stringify(data),
        headers:{
            "Content-type": "application/json; charset=UTF-8"
        }
    })
    .then(function(response){
        return response.json()
    })
    .then(function (data){
        console.log(data);
    })
    .catch(error=> console.log(error))
   
   })
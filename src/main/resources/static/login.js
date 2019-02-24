function selectUserType() {
	var type = document.getElementById("user_type").value;
	var emailField = document.getElementById("patient");
	var accessIDField = document.getElementById("nurse");
	var ppnField = document.getElementById("doctor");
	var passwordSubmit = document.getElementById("password_submit");
  	//document.getElementById("demo").innerHTML = "You selected: " + type;
  	if (type == "patient"){
  		emailField.style.display = "block";
  		accessIDField.style.display = "none";
  		ppnField.style.display = "none";
  		passwordSubmit.style.display = "block";
  	} else if (type == "nurse") {
  		emailField.style.display = "none";
		accessIDField.style.display = "block";
		ppnField.style.display = "none";
		passwordSubmit.style.display = "block";
  	} else if (type == "doctor") {
  		emailField.style.display = "none";
  		accessIDField.style.display = "none";
  		ppnField.style.display = "block";
  		passwordSubmit.style.display = "block";
  	}
}

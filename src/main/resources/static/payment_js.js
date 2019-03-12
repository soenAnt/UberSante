function validate(){
    var number = document.getElementById('number');
    var month = document.getElementById('month');
    var year = document.getElementById('year');
    var cvc = document.getElementById('cvc');

    var numberRegex = /^[0-9]{12}$/;
    var monthRegex = /^[1-9]|1[0-2]$/;
    var yearRegex = /^[0-9]{2}$/;
    var cvcRegex = /^[0-9]{3}$/;

    if(numberRegex.test(number) && monthRegex.test(month) &&
    yearRegex.test(year) && cvcRegex.test(cvc)){
        return true;
    }
    else{
        alert("Credit card is not valid");
    }
}
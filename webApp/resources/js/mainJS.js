var car = {
	type : 'Metsobeshe',
	color : ' back',
	price : '150000'
};

function test(value) {
	if (value == 'type') {
		var t = getCar().type;
		alert(' Type : '.concat(t));
	} else if (value == 'color') {
		var c = getCar().color;
		alert(' Color : '.concat(c));
	} else if (value == 'price') {
		var p = getCar().price;
		alert(' Price: '.concat(p));
	}
}

function getCar() {
	return car;
}

function addNumbers(val1, val2) {
	multiply(4, 7);
	return val1 * val2;
}

function testInputLenght(id, fieldName) {

	var el = document.getElementById(id);
	if (el.value != null && el.value.length < 3) {
		var msg = 'The Field '.concat(fieldName).concat(
				'To Small and must be more than 3 character');
		alert(msg);
		el.value = '';
		el.focus();
	}

}

// --------------------------------
var i = 0;
function changeImage(id) {
	var array = [ 'Desert.jpg', 'Hydrangeas.jpg', 'Jellyfish.jpg', 'Koala.jpg',
			'Lighthouse.jpg', 'Penguins.jpg' ];
	var element = document.getElementById(id);
	var src = element.getAttribute('src');

	var value = array[i];
	var val = 'resources/images/'.concat(value);
	i++;
	element.setAttribute('src', val);
	if (i == array.length) {
		i = 0;
	}
}

function setUserName(id) {

	var myName = prompt('Please enter your name.');
	localStorage.setItem('name', myName);
	var element = document.getElementById(id);
	element.textContent = myName;

}

function showDate(id) {
	var options = {
		year : "2-digit",
		month : "2-digit",
		day : "2-digit",
		hour : "2-digit",
		minute : "2-digit",
		second : "2-digit",
		timeZoneName : "short"
	};
	var americanDateTime = new Intl.DateTimeFormat("en-US", options).format;
	console.log(americanDateTime(new Date()));
	element = document.getElementById(id).innerHTML = americanDateTime(new Date());
}

function deleteConfirmation(name) {
	var msg = "Are you sure want to delete TempTable named :".concat(name);
	return confirm(msg);
}

// end

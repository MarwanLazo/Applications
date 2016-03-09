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
	var rs = confirm(msg);
	return rs;
}

// ---------- consume WS
function consumeWS() {
	$.ajax({
		type : 'Get',
		url : 'http://localhost:7007/sprTest/rest/employees',
		success : function(data) {
			var html = '<table border="1" cellspacing="0" cellpadding="10" 	>';
			html += '<tr><th> Name </th><th> Email </th><th> Email </th></tr>'
			for (var i = 0; i < data.length; i++) {
				html += '<tr><td>' + data[i]['tempName'] + '</td><td>'
						+ data[i]['tempEmail'] + '</td>';
				if (data[i]['tempRef'] != null) {
					html += "<td>" + data[i]['tempRef']['tempName'] + "</td>";
				} else {
					html += '<td>No Ref</td>'
				}

				console.log("----->>>------------------------>>>".concat(i));
				html += '</tr>'
			}
			html += '</table>'
			$("#divResults").replaceWith(
					$("<div id='divResults' >" + html + "</div>"));
		}
	});

}
var x = 0;
function addStuff() {
	var words = [ 'one', 'two', 'three' ];

	var html = '<table border="1" cellspacing="0" cellpadding="0" 	>';
	html += '<tr><th> Numbers </th></tr>'
	$.each(words, function(i, word) {
		html += '<tr><td>' + word + '</td></tr>';
	});

	html += '</table>';

	$("#divResults").replaceWith($("<div id='divResults' >" + html + "</div>"));
	x++;
	console.log(x);
}

var anyThing = {
	color : 'Black',
	lagsCount : 4,
	comunicate : function(cont) {
		for (var int = 0; int < cont; int++) {
			alert("Woof".toUpperCase());
		}
	}
};

var myDog = {
	bark : function() {
		alert('Woof!');
	}
};

var myCat = {
	meow : function() {
		alert('I am a lazy cat. I will not meow for you.');
	}
};

function annoyThePet(name) {
	var num = 15;
	console.log(String.replace(num, /5/, '2'));
}

function partOfDay() {
	var hour = new Date().getHours();

	if (hour <= 12) {
		return 'morning';
	} else if (hour <= 5) {
		return 'afternoon';
	} else {
		return 'evening';
	}
}

// end


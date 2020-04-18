console.log("Script.js loaded");

window.addEventListener('load', evt => {
	console.log('Page loaded');
	init();
});

function init(){
	console.log("Inside init()");
//	document.eventForm.lookup.addEventListener('click', function(event) {
//		event.preventDefault();
//		var eventId = document.eventForm.eventId.value;
//		if (!isNaN(eventId) && eventId > 0) {
//		  getEvent(eventId);
//		}
//	  });
	getAllEvents();
	document.createEventForm.eventSubmit.addEventListener('click', function(event) {
		event.preventDefault();
		createEvent(document.createEventForm);
	});
}


function createEvent(formObj) {
	var xhr = new XMLHttpRequest();
	xhr.open('POST', 'api/trackers/'+formObj.emotion.value, true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
	  if (xhr.readyState === 4 ) {
	    if ( xhr.status == 200 || xhr.status == 201 ) { // Ok or Created
	      var data = JSON.parse(xhr.responseText);
	      console.log(data);
	      getAllEvents();
	    }
	    else {
	      console.log("POST request failed.");
	      console.error(xhr.status + ': ' + xhr.responseText);
	    }
	  }
	};

	var userObject = {
	  description: formObj.description.value, 
	};
	var userObjectJson = JSON.stringify(userObject); // Convert JS object to JSON string

	xhr.send(userObjectJson);
}

function getAllEvents() {
	let xhr = new XMLHttpRequest();
  
	xhr.open('GET', 'api/trackers/');
	xhr.onreadystatechange = function (){
		
	  if ( xhr.readyState === 4){
		if( xhr.status === 200){
		  let dataJSON = xhr.responseText;
		  let eventsObj = JSON.parse(dataJSON);
		  console.log(eventsObj);
		  displayAllEvents(eventsObj);
		}
		else if ( xhr.status === 404 ){
		  displayAllEvents(null);
		  console.log('Events not found.');
		}
	  }
	}
	xhr.send();
}

function getEvent(eventId) {
	let xhr = new XMLHttpRequest();
  
	xhr.open('GET', 'api/trackers/'+eventId);
	xhr.onreadystatechange = function (){
		
	  if ( xhr.readyState === 4){
		if( xhr.status === 200){
		  let dataJSON = xhr.responseText;
		  let eventObj = JSON.parse(dataJSON);
		  console.log(eventObj);
		  displayEvent(eventObj);
		}
		else if ( xhr.status === 404 ){
		  displayEvent(null);
		  console.log('Event not found.');
		}
	  }
	}
	xhr.send();
}

function displayEvent(event){
	var dataDiv = document.getElementById('eventData');
	dataDiv.textContent = '';
	if (event == null){
		dataDiv.textContent = 'Event not found';
	}else{
		let title = document.createElement('h1');
		title.textContent = event.emotion.name;
		dataDiv.appendChild(title);
		
		let description = document.createElement('blockquote');
		description.textContent = event.description;
		dataDiv.appendChild(description);

		let editform = document.createElement('form');
		editform.name = 'editEventForm';
		dataDiv.appendChild(editform);

		let idelement = document.createElement('input'); // Create Input Field for Name
		idelement.setAttribute("type", "hidden");
		idelement.setAttribute("name", "id");
		idelement.value = event.id;
		editform.appendChild(idelement);

		let descLabel = document.createElement('label'); // Create Label for Name Field
		descLabel.textContent = "Description: "; // Set Field Labels
		editform.appendChild(descLabel);

		let inputelement = document.createElement('input'); // Create Input Field for Name
		inputelement.setAttribute("type", "text");
		inputelement.setAttribute("name", "description");
		inputelement.value = event.description;
		editform.appendChild(inputelement);

		let linebreak = document.createElement('br');
		editform.appendChild(linebreak);

		let emotionLabel = document.createElement('label'); // Create Label for E-mail Field
		emotionLabel.innerHTML = "Emotion: ";
		editform.appendChild(emotionLabel);

		let selectelement = document.createElement('select');
		selectelement.name = 'emotion';
		editform.appendChild(selectelement);

		let optionElement1 = document.createElement('option');
		if (event.emotion.id === 1) {
			optionElement1.selected = "selected";
		}
		optionElement1.value = 1;
		optionElement1.textContent = "Love";
		selectelement.appendChild(optionElement1);

		let optionElement2 = document.createElement('option');
		if (event.emotion.id === 5) {
			optionElement2.selected = "selected";
		}
		optionElement2.value = 5;
		optionElement2.textContent = "Joy";
		selectelement.appendChild(optionElement2);

		let optionElement3 = document.createElement('option');
		if (event.emotion.id === 12) {
			optionElement3.selected = "selected";
		}
		optionElement3.value = 12;
		optionElement3.textContent = "Surprise";
		selectelement.appendChild(optionElement3);

		let optionElement4 = document.createElement('option');
		if (event.emotion.id === 13) {
			optionElement4.selected = "selected";
		}
		optionElement4.value = 13;
		optionElement4.textContent = "Anger";
		selectelement.appendChild(optionElement4);

		let optionElement5 = document.createElement('option');
		if (event.emotion.id === 18) {
			optionElement5.selected = "selected";
		}
		optionElement5.value = 18;
		optionElement5.textContent = "Sadness";
		selectelement.appendChild(optionElement5);

		let optionElement6 = document.createElement('option');
		if (event.emotion.id === 25) {
			optionElement6.selected = "selected";
		}
		optionElement6.value = 25;
		optionElement6.textContent = "Fear";
		selectelement.appendChild(optionElement6);

		let optionbreak = document.createElement('br');
		editform.appendChild(optionbreak);

		let submitelement = document.createElement('input'); // Append Submit Button
		submitelement.setAttribute("type", "submit");
		submitelement.setAttribute("name", "dsubmit");
		submitelement.setAttribute("value", "Submit");
		editform.appendChild(submitelement);
		submitelement.addEventListener('click',updateEvent );

  	}
}

function updateEvent(e){
	e.preventDefault();
	let form = e.target.parentElement;
	var xhr = new XMLHttpRequest();
	xhr.open('PUT', 'api/trackers/'+form.id.value, true);

	xhr.setRequestHeader("Content-type", "application/json"); // Specify JSON request body

	xhr.onreadystatechange = function() {
	  if (xhr.readyState === 4 ) {
	    if ( xhr.status == 200 || xhr.status == 201 ) { // Ok or Created
	      var data = JSON.parse(xhr.responseText);
	      console.log(data);
	      getAllEvents();
	    }
	    else {
	      console.log("POST request failed.");
	      console.error(xhr.status + ': ' + xhr.responseText);
	    }
	  }
	};

	var userObject = {
	  description: form.description.value, 
	  emotion: {
		  id: form.emotion.value
	  }
	};
	var userObjectJson = JSON.stringify(userObject); // Convert JS object to JSON string

	xhr.send(userObjectJson);
}

function tableRowClick(eventId){
	//var eventId = event.target.td.event.id;
	if (!isNaN(eventId) && eventId > 0) {
		getEvent(eventId);
	}
};

function displayAllEvents(events) {
	var dataDiv = document.getElementById('eventData');
	dataDiv.textContent = '';
	if (events == null){
		eventTable.textContent = 'Events not found';
	}else{
		// create all table header elements and append to table
		let table = document.createElement('table');
		table.border = 1;
		dataDiv.appendChild(table);
		let tableHead = document.createElement('thead');
		let tableHeaderRow = document.createElement('tr');
		let tableHeaderRowId = document.createElement('th');
		let tableHeaderRowDesc = document.createElement('th');
		let tableHeaderRowEcat = document.createElement('th');
		let tableHeaderRowEname = document.createElement('th');
		let tableHeaderRowEdesc = document.createElement('th');
		let tableHeaderRowLogdate = document.createElement('th');
		// give a value to the column headers and append to tr
		tableHeaderRowId.textContent = 'id';
		tableHeaderRowLogdate.textContent = 'Log date';
		tableHeaderRowDesc.textContent = 'Description';
		tableHeaderRowEcat.textContent = 'Emotion category';
		tableHeaderRowEname.textContent = 'Emotion name';
		tableHeaderRowEdesc.textContent = 'Emotion description';
		tableHeaderRow.appendChild(tableHeaderRowId);
		tableHeaderRow.appendChild(tableHeaderRowDesc);
		tableHeaderRow.appendChild(tableHeaderRowEcat);
		tableHeaderRow.appendChild(tableHeaderRowEname);
		tableHeaderRow.appendChild(tableHeaderRowEdesc);
		tableHeaderRow.appendChild(tableHeaderRowLogdate);
		tableHead.appendChild(tableHeaderRow);
		table.appendChild(tableHead);


		let tableBody = document.createElement('tbody');
		table.appendChild(tableBody);

		events.forEach(function(event,index,array){
			let tableRow = document.createElement('tr');
			tableBody.appendChild(tableRow);

			tableRow.addEventListener('click', function(){ tableRowClick(event.id); } );

			let logId = document.createElement('td');
			logId.textContent = event.id;
			tableRow.appendChild(logId);


			let logdesc = document.createElement('td');
			logdesc.width = "40%";
			logdesc.textContent = event.description;
			tableRow.appendChild(logdesc);

			let emotionCat = document.createElement('td');
			emotionCat.textContent = event.emotion.category;
			tableRow.appendChild(emotionCat);
			
			let emotionName = document.createElement('td');
			emotionName.textContent = event.emotion.name;
			tableRow.appendChild(emotionName);	
			
			let emotionDesc = document.createElement('td');
			emotionDesc.textContent = event.emotion.description;
			tableRow.appendChild(emotionDesc);
			
			let logdate = document.createElement('td');
			logdate.textContent = event.logDate;
			tableRow.appendChild(logdate);
		});
		
	}
}
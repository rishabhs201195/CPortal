$(document).ready(
		function() {

			// SUBMIT FORM
			$("#addForm").submit(function(event) {
				// Prevent the form from submitting via the browser.
				event.preventDefault();
				ajaxPost();
			});

			function ajaxPost() {

				// PREPARE FORM DATA
				var formData = {
					roll : $("#roll").val(),
					room : $("#room").val(),
					hostel : $("#hostel").val()
				}

				// DO POST
				$.ajax({
					type : "POST",
					contentType : "application/json",
					url : "/saveStudent",
					data : JSON.stringify(formData),
					dataType : 'json',
					success : function(result) {
				        if(result.status == "Done"){
				          $("#postResultDiv").html("<div style='background-color:#006400; color:white; border: 2px; padding:5px 10px 5px 20px'>" + 
				                        "Student with " +"Roll No. " + result.data.roll + 
				                        " and  Room No. " + result.data.room + " added Succesfully " + "</div>");
				        }else{
				          $("#postResultDiv").html("<div style='background-color:#FF0000; color:white; border: 2px; padding:5px 10px 5px 20px'>" + 
			                        "Student Already Added " + "</div>");
				        }
				        console.log(result);
				      },
				      error : function(e) {
				        alert("Error in Adding Student")
				        console.log("ERROR: ", e);
				      }
				});
				resetData();

			}
			function resetData(){
			      $("#room").val("");
			    }

		})
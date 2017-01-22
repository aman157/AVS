$(document).ready(function(){
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	$("#physicsBtw").hide();
	$("#chemistryBtw").hide();
	$("#mathsBtw").hide();
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	$(".deleteStatus").hide();

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	$('#physicsDrp').change(function() {
		if($(this).val() == "between") {
			$("#physicsBtw").show();
		}
		else{
			$("#physicsBtw").hide();
		}
	});
	$('#chemistryDrp').change(function() {
		if($(this).val() == "between") {
			$("#chemistryBtw").show();
		}
		else{
			$("#chemistryBtw").hide();
		}
	});
	$('#mathsDrp').change(function() {
		if($(this).val() == "between") {
			$("#mathsBtw").show();
		}
		else{
			$("#mathsBtw").hide();
		}
	});

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	$("#imgInp").change(function(){
		readURL(this);
	});
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function (e) {
				$("#blah").attr("src", e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	var timer;
	$(document).on("click",".edit",function () {
		var $this=$(this);
		count=0;
		var btnValue=$(this).val();
		if(btnValue=="Edit"){
			$(this).attr("value","Save");
			$(this).html('<span class="editGlyp glyphicon glyphicon-floppy-disk"></span> Save');
			var row = $(this).closest('tr');
			$(row).find('.name,.physicsMarks,.chemistryMarks,.mathsMarks').prop("readonly",false);
			$(row).find('.name').focus();
		}
		else
		{	
			var name=$(this).closest('tr').find("#name").val();	
			var rollNumber=$(this).closest('tr').find("#rollNumber").val();
			var physicsMarks=$(this).closest('tr').find("#physicsMarks").val();
			var chemistryMarks=$(this).closest('tr').find("#chemistryMarks").val();
			var mathsMarks=$(this).closest('tr').find("#mathsMarks").val();
			
			
			if(/^[a-zA-Z]*$/.test(name)==false || name.length>=3==false){
				$(this).closest('tr').find(".nameErr").text("Greater than 3 Alphabets");
				count++;
			}
			if(physicsMarks < 0 || physicsMarks > 100 || physicsMarks=="" || /^[a-zA-Z]*$/.test(physicsMarks)==true){
				$(this).closest('tr').find(".physicsMarksErr").text("Numbers between 0-100 Only");
				count++;
			}
			
			if(chemistryMarks < 0 || chemistryMarks > 100 || chemistryMarks=="" || /^[a-zA-Z]*$/.test(chemistryMarks)==true){
				$(this).closest('tr').find(".chemistryMarksErr").text("Numbers between 0-100 Only");
				count++;
			}
			 if(mathsMarks < 0 || mathsMarks > 100 || mathsMarks=="" || /^[a-zA-Z]*$/.test(mathsMarks)==true){
				$(this).closest('tr').find(".mathsMarksErr").text("Numbers between 0-100 Only");
				count++;
			}
			if(count==0){
				$(this).closest('tr').find(".nameErr,.physicsMarksErr,.chemistryMarksErr,.mathsMarksErr").text("");
				var formData=new FormData();
				formData.append("name", name);
				formData.append("rollNumber",rollNumber);
				formData.append("physicsMarks", physicsMarks);
				formData.append("chemistryMarks", chemistryMarks);
				formData.append("mathsMarks", mathsMarks);
				$.ajax({
					type: "POST",
					url: "editAction.action",
					cache: false,
					contentType: false,
					processData: false,
					data: formData,
					datatype:"json",
					success:function () { 
						$this.attr("value","Edit");
						$this.closest('tr').find('.name,.physicsMarks,.chemistryMarks,.mathsMarks').prop("readonly",true);
						$this.html('<span class="editGlyp glyphicon glyphicon-edit"></span> EDIT');
			
						$this.closest('tr').find('.savingStatus').text("SAVED !!");
				
						clearTimeout(timer);
						
						setTimeout(function(){
							$this.closest('tr').find('.savingStatus').text("");	
						}, 2000);
					},
				});
			}
			
		}
			
		});
			
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	$(".delete").click(function () {
		var $this=$(this);
		var row = $(this).closest('tr');
		var rollNum=$(row).find("#rollNumber").val();
		$.ajax({
			type: "GET",
			url : "deleteAction/"+rollNum,
			success : function() {
				$this.parent().parent().remove();
				$('.sorted-table').trigger('update');
				$(".deleteStatus").show();
				setTimeout(function(){
					$('.deleteStatus').hide();	
				}, 2000);
				return true;
			},
		});
	});

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	$(document).on('change', '#updateViewImage', function(e) {
		var $this=$(this);
		var path= $(this).closest('tr').find("img");
		
		var filename= $(this).closest('tr').find("#updateViewImage").val();
		var extension = filename.split('.').pop();
		var size=this.files[0].size;
		
		if((extension=="jpg" || extension=="JPG" || extension=="png" || extension=="PNG") && (size<=900000))
		{
			
			var rollNumber=$(this).closest('tr').find("#rollNumber").val();
			var pic= $(this).closest('tr').find("#updateViewImage")[0].files[0];
			
			$(this).closest('tr').find('.uploadPicErr').prepend('<img id="theImg" src="resources/images/progressBar.gif" height="40px" width=""/>');
			
			var files = !!this.files ? this.files : [];
			if (!files.length || !window.FileReader) return; // no file selected, or no FileReader support
			if (/^image/.test( files[0].type)){ // only image file
				var reader = new FileReader(); // instance of the FileReader
				reader.readAsDataURL(files[0]); // read the local file
				reader.onloadend = function(){ // set image data as background of div
					$(path).attr("src", this.result);
				}
			}
			var formData=new FormData();
			formData.append("rollNumber",rollNumber);
			formData.append("file", pic);
				$.ajax({
					type: "POST",
					url: "uploadAction.action",
					cache: false,
					contentType: false,
					processData: false,
					data: formData,
					datatype:"json",
					success:function () { 
						$this.closest('tr').find(".uploadPicErr").text("UPLOADED !!");
						setTimeout(function(){
							$this.closest('tr').find(".uploadPicErr").text("");
						}, 2000);
						
					},
				});
		}
		else{
			$(this).closest('tr').find(".uploadPicErr").text("Only jpg & Png less than 900kb");
		}
	});
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
});

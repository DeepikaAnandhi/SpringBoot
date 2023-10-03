/**
 * 
 */

 function validation(frm){
	 
//emptying the existing the error messages
	 	document.getElementById("enameErr").innerHTML="";
	 	document.getElementById("jobErr").innerHTML="";
	 	document.getElementById("salErr").innerHTML="";
	 	document.getElementById("deptnoErr").innerHTML="";
	 	
//read the form data	 	
	 	let name= frm.ename.value;
	 	let job=frm.job.value;
	 	let sal = frm.sal.value;
	 	let dno = frm.deptno.value;
	 	
//write form validation logic
	
		let vflag = true;
		if(name="" || name.length()==0){
			document.getElementById("enameErr").innerHTML="Employee Name is Mandatory(cs)";
			vflag=false;
		}
		else if(name.length()<5 ||name.length()>15){
			document.getElementById("enameErr").innerHTML="Employee Name is must be min of 5 chars and Max of 15 chars(cs)";
			vflag=false;
		}
		if(job="" || job.length()==0){
			document.getElementById("jobErr").innerHTML="Job is Mandatory(cs)";
			vflag=false;
		}
		else if(job.length()<5 ||job.length()>15){
			document.getElementById("jobErr").innerHTML="Job is must be min of 5 chars and Max of 15 chars(cs)";
			vflag=false;
		}
		if(sal="" || name.length()==0){
			document.getElementById("salErr").innerHTML="Salary is Mandatory(cs)";
			vflag=false;
		}
		else if(isNaN(sal)){
			document.getElementById("salErr").innerHTML="Salary must be numeric (cs)";
			vflag=false;
		}
	 return vflag;
 }
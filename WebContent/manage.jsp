<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="servicelayer.CallApi" %>
    <%@ page import="servicelayer.ServiceImple" %>
   <%@ page import="servicelayer.ServiceInf" %>
   <%@ page import="java.util.List" %>
    <%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
  <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
  <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>

<script type="text/javascript">
$(function () {
    $("#tabs").tabs();
    $("#accordion").accordion();

    $('#btnSave').click(function () {
        console.log("hello");

        $.ajax({
            url: '/RlDevopsDashboard/configure',
            type: 'POST',
            datatype: 'text',
            success: function (data) {
                alert("success");
                var values = [];


                values = data;
                console.log(values.length);
                var str = values.trim().split(',');
                for (i in str) {
                    console.log(str[i]);
                    $("#instList").append('<option value="' + str[i] + '"> ' + str[i] + ' </option>');
                }


            }
        });
    });
    
     $('#btnSave').click(function () {
        console.log("hello");

        $.ajax({
            url: '/RlDevopsDashboard/response',
            type: 'POST',
            datatype: 'text',
            success: function (result) {
                //alert("success");
                var values = [];


                values = result;
                console.log(values.length);
                var str = values.trim().split(',');
                for (i in str) {
                    console.log(str[i]);
                    $("#amiId").append('<option value="' + str[i] + '"> ' + str[i] + ' </option>');
                }


            }
        });
    }); 
     $('#btnKeyPair').click(function () {
    	 
    	 $.post( "/RlDevopsDashboard/getami", function( data ) {
    		 var values = [];
             values = data;
             console.log(values.toString());
             var str = values.trim().split(',');
    		 for (i in str) {
                 console.log(str[i]);
                 $("#keypair").append('<option value="' + str[i] + '"> ' + str[i] + ' </option>');
             }
    		});
    	 
     });
     
		$('#btnAmid').click(function () {
    	 
    	 $.post( "/RlDevopsDashboard/GetImages", function( data ) {
    		 var values = [];
             values = data;
             console.log(values.toString());
             var str = values.trim().split(',');
    		 for (i in str) {
                 console.log(str[i]);
                 $("#ami").append('<option value="' + str[i] + '"> ' + str[i] + ' </option>');
             }
    		});
    	 
     });
		
		
		
		$('#btnCreate').click(function () {
			var insType=$('#insTypeList :selected').text();
			var amid=$('#ami :selected').text();
			var keypair=$('#keypair :selected').text();
			var endPoint=$('#endPoint :selected').text();
			var securityGroup=$('#securityGroup :selected').text();
			var miIns=$('#miIns').val();
			var maIns=$('#maIns').val();
			var keyName=$('#keyName').val();
			console.log(maIns);
	    	 $.post( "/RlDevopsDashboard/CreateInstance",{"insTypeList": insType,"ami":amid,"keypair":keypair,"endPoint":endPoint,"miIns":miIns,"maIns":maIns,"keyName":keyName,"securityGroup":securityGroup}, function( data ) {
	    		 var values = [];
	             values = data;
	             console.log(values.toString());
	             var str = values.trim().split(',');
	             console.log(str);
	    		if(str.length>0)
	    			{
	    			
	    				$('#lblIns').text("No Instance Created");
	    				
	    			} 
	    		else
	    			{
	             $('#lblInsId').text("Instance-Id :");
	             $('#lblInsIdVal').text(str[0]);
	            $('#lblAmid').text("Amid :");
	             $('#lblAmidVal').text(str[1]);
	             
	             $('#lblKeyPair').text("Key Pair :");
	             $('#lblKeyPairVal').text(str[2]);
	            
	             $('#lblInsType').text("Instance Type :");
	             $('#lblInsTypeVal').text(str[3]);
	             
	             $('#lblInsStatus').text("Status :");
	             $('#lblInsStatusVal').text(str[4]); 
	             $('#insTypeList').val("");
	             $('#ami').val("");
	             $('#keypair').val("");
	             $('#endPoint').val("");
	             $('#securityGroup').val("");
	             $('#miIns').val("");
	             $('#maIns').val("");
	             $('#keyName').val("");
	    			}
	    		});
	    	 
	     });
		
		
		$('#btnSecId').click(function () {
	    	 
	    	 $.post( "/RlDevopsDashboard/SecurityGroup", function( data ) {
	    		 var values = [];
	             values = data;
	             console.log("called");
	             var str = values.trim().split(',');
	    		  for (i in str) {
	                 console.log(str[i]);
	                 $("#securityGroup").append('<option value="' + str[i] + '"> ' + str[i] + ' </option>');
	             } 
	    		});
	    	 
	     });
		
});
 
</script>
</head>
<style>
#myList,#instList,#amiId,#endPoint,#insTypeList,#ami,#keypair,#noi,#keyName,#securityGroup
{
  margin: 5px;
  
  width: 223px;
  height: 25px;
  color: #404040;
  background: white;
  border: 1px solid;
  border-color: #c4c4c4 #d1d1d1 #d4d4d4;
  border-radius: 2px;
  outline: 5px solid #eff4f7;
  font-size: x-small;
}
.container
{
position: relative;
  margin: 0 auto; 
   padding: 20px 20px 20px; 
  width: 700px;
  background: white;
  border-radius: 1px;
  border-color: #0088cc;
  border-width: thin;
  border-style: solid;
  
}
#btnSave,#btnCreate
{
background-color: #0088cc;
font-size: x-small;
}
#btnAmid,#btnKeyPair,#btnSecId{color:#0088cc;font-size: x-small; background-color: white; border-style: none;}
h3
{
  color:#0088cc;
  font-size:14px !IMPORTANT;font-weight:bold;
}
.label{font-size: x-small;color:#0088cc; }
.label1{font-size: x-small;color:#0088cc; width:100px;}
.label2{font-size: x-small; width:100px;}
.label3{font-size: medium; width:100px;color:red;}
#aki,#sak,#ami,#select{font-size: x-small;width: 223px;}
.labelclass{font-size:14px;font-weight:bold;}
#miIns,#maIns{margin: 5px;
  
  width: 50px;
  height: 15px;
  color: #404040;
  background: white;
  border: 1px solid;
  border-color: #c4c4c4 #d1d1d1 #d4d4d4;
  border-radius: 2px;
  
  font-size: xx-small;}
</style>
<body>
<div class="tabbable" id="tabs">
  <ul class="nav nav-tabs">
    <li class="active"><a href="#tab1" id="1" class="labelclass">AWS</a></li>
    <li><a href="#tab2" id="1" class="labelclass">CloudStack</a></li>
  </ul>
  <div class="tab-content">
    <div id="tab1">
    
    <div id="accordion">
      <h3>Configure</h3>
     
      <div>
      <div class="container">
     <table>
        <tr>
         <td><span class="label">Access Key ID</span></td>
         <td><input type="text" id="aki" name="aki"/></td>
        </tr>
        <tr>
         <td><span class="label">Secret Access Key</span></td>
         <td><input type="text" id="sak" name="sak"/></td>
        <tr>
         <td><span class="label">EndPoint</span></td>
         <td><select id = "myList" name="ep">
               <option value = "eu-west-1">eu-west-1</option>
               <option value = "sa-east-1">sa-east-1</option>
               <option value = "us-east-1">us-east-1</option>
               <option value = "us-west-">us-west-1</option>
               <option value = "us-west-2">us-west-2</option>
               <option value = "ap-northeast-1">ap-northeast-1</option>
                <option value = "ap-southeast-1">ap-southeast-1</option>
                <option value = "ap-southeast-2">ap-southeast-2</option>
             </select></td><td></td>
         <td></td>
         <td><button class="btn" id="btnSave">Save</button></td>
         </tr>  
     </table>  
       </div>
       </div>
     <h3>Create Instance</h3>
        <div>
         <div class="container" id="list">
         <table>
          <tr>
          <td><span class="label">Instance Type</span></td>
          <td><select id = "insTypeList" name="insTypeList">
                <option value ="" id="select">Select</option>
          		<option value ="m1.small" id="select">m1.small</option>
          		<option value ="m1.medium" id="select">m1.medium</option>
          		<option value ="m1.larg" id="select">m1.large</option>
          		<option value ="m1.xlarg" id="select">m1.xlarge</option>
          		<option value ="m3.xlarge" id="select">m3.xlarge</option>
          		<option value ="m3.2xlarge" id="select">m3.2xlarge</option>
          		<option value ="c1.medium" id="select">c1.medium</option>
          		<option value ="c1.xlarge" id="select">c1.xlarge</option>
          		<option value ="c1.xlarge" id="select">c1.xlarge</option>
          		<option value ="c3.xlarge" id="select">c3.xlarge</option>
          		<option value ="c3.2xlarge" id="select">c3.2xlarge</option>
          		<option value ="c3.4xlarge" id="select">c3.4xlarge</option>
          		<option value ="c3.8xlarge" id="select">c3.8xlarge</option>
          		<option value ="cc2.8xlarge" id="select">cc2.8xlarge</option>
          		<option value ="m2.xlarge" id="select">m2.xlarge</option>
          		<option value ="m2.xlarge" id="select">m2.xlarge</option>
          		<option value ="m2.4xlarge" id="select">m2.4xlarge</option>
          		<option value ="cr1.8xlarg" id="select">cr1.8xlarge</option>
          		<option value ="hi1.4xlarge" id="select">hi1.4xlarge</option>
          		<option value ="hs1.8xlarge" id="select">hs1.8xlarge</option>
          		<option value ="t1.micro" id="select">t1.micro</option>
          		<option value ="cg1.4xlarge" id="select">cg1.4xlarge</option>
          		<option value ="g2.2xlarge" id="select">g2.2xlarge</option>
             </select></td>
          </tr>
          <tr>
          <td><span class="label">AMID</span></td>
          <td><select id = "ami" name="ami">
          <option value ="">Select</option>
          </select></td>
          <td><button class="btn" id="btnAmid"><u>Get AmIDs</u></button></td>
          </tr>
          <tr>
          <td><span class="label">Security Group Id</span></td>
          <td><select id = "securityGroup" name="securityGroup">
          <option value ="">Select</option>
          </select></td>
          <td><button class="btn" id="btnSecId"><u>Check Security GroupId</u></button></td>
          </tr>
          <tr>
          <td><span class="label">Key Pairs</span></td>
          <td><select id = "keypair" name="keypair">
          <option value ="">Select</option>
          </select></td>
          <td><button class="btn" id="btnKeyPair"><u>Get Key</u></button></td>
          </tr>
          <tr>
          <td><span class="label">End Point</span></td>
          <td><select id = "endPoint" name="endPoint">
          <option value ="">Select</option>
               <option value = "us-east-1a">us-east-1a</option>
               <option value = "us-east-1c">us-east-1c</option>
               <option value = "us-east-1d">us-east-1d</option>
               <option value = "us-west-">us-west-1</option>
               <option value = "us-west-2">us-west-2</option>
               <option value = "ap-northeast-1">ap-northeast-1</option>
                <option value = "ap-southeast-1">ap-southeast-1</option>
                 <option value = "ap-southeast-2">ap-southeast-2</option>
          </select></td>
          </tr>
          <tr>
          <td><span class="label">Min Instances</span></td>
          <td><input type="text" id="miIns" name="miIns"/></td>
          <td><span class="label">Max Instances</span></td>
          <td><input type="text" id="maIns" name="maIns"/></td>
          </tr>
          <tr>
          <td></td>
          <td></td>
          <td><button class="btn" id="btnCreate">Create</button></td></tr>
          </table>
          <table>
          <tr>
          <td><span class="label3" id="lblIns"></span></td>
          <td><span class="label1" id="lblInsId"></span></td>
          	  <td><span class="label2" id="lblInsIdVal"></span></td>&nbsp;
          	  <td><span class="label1" id="lblAmid"></span></td>
          	  <td><span class="label2" id="lblAmidVal"></span></td>&nbsp;
          	  <td><span class="label1" id="lblKeyPair"></span></td>
          	  <td><span class="label2" id="lblKeyPairVal"></span></td>&nbsp;
          	  <td><span class="label1" id="lblInsType"></span></td>
          	  <td><span class="label2" id="lblInsTypeVal"></span></td>
          	  
          	  <td><span class="label" id="lblInsStatus"></span></td>
          	  <td><span class="label" id="lblInsStatusVal"></span></td>
          
          </tr>
          
         </table>
       </div>
       </div>
        <h3>Describe Instance</h3>
        <div>
         <div class="container" id="list">
         <table>
          <tr>
          <td><span class="label">Instance Type</span></td>
          <td><select id = "instList" name="">
                <option value ="" id="select">Select</option>
          
             </select></td>
          </tr>
          <tr>
          <td><span class="label">Instance Name</span></td>
          <td><select id = "amiId" name="">
          <option value ="" id="select">Select</option>
          </select></td>
          </tr>
          <tr>
          <td><span class="label">Number of Instances</span></td>
          <td><select id = "noi" name="noi">
          <option value = "">Select</option>
               <option value = "1">1</option>
               <option value = "2">2</option>
               <option value = "3">3</option>
          </select></td>
          </tr>
          
         </table>
       </div>
       </div>
    </div>
    </div>
    <div class="tab-pane" id="tab2">
      <p>CloudStack</p>
    </div>
  </div>
</div>
</body>
</html>
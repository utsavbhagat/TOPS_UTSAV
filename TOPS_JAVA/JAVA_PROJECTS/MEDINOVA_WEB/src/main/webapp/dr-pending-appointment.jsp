<%@page import="dao.PatientDao"%>
<%@page import="model.Patient"%>
<%@page import="dao.AppointmentDao"%>
<%@page import="model.Appointment"%>
<%@page import="dao.PackageDao"%>
<%@page import="java.util.List"%>
<%@page import="model.Packages"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="dr-header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pending appointment</title>
</head>
<body>
<%List<Packages> pack_list = PackageDao.getPackagesByDid(d.getDid()); %>
<%List<Appointment> app_list = AppointmentDao.getAllAppoinements(); %>
<%
for(Packages p:pack_list){
	%>
	
	
	<!-- Blog Start -->
	<div class="container-fluid py-5">
		<div class="container">
			<div class="text-center mx-auto mb-5" style="max-width: 500px;">
				<h5
					class="d-inline-block text-primary text-uppercase border-bottom border-5">Blog
					Post</h5>
				<h1 class="display-4">Pending appointment</h1>
			</div>
			<div class="row g-5">
			<%List<Appointment> all_pending_app = AppointmentDao.getAllPendingAppoinements(p.getP_id()); %>
			<%
			for(Appointment a:all_pending_app){
				Appointment appointment = AppointmentDao.getAppoinementsByAid(a.getAid());
				Patient patient  = PatientDao.getpatientByPid(appointment.getPid());
			%>
				<div class="col-xl-4 col-lg-6">
					<div class="bg-light rounded overflow-hidden">
						<img class="img-fluid w-100" src="img/blog-1.jpg" alt="">
						<div class="p-4">
							<a class="h3 d-block mb-3" href="#"><%=patient.getName() %></a>
							<p class="m-0"><%=patient.getContact() %></p>
						</div>
						<div class="d-flex justify-content-between border-top p-4">
							<div class="d-flex align-items-center">
								<img class="rounded-circle me-2" src="img/user.jpg" width="25"
									height="25" alt=""> <small><%=appointment.getP_name() %></small>
							</div>
							<div class="d-flex align-items-center">
								<small class="ms-3">
								<i class="bi bi-currency-rupee"></i>Rs. <%=p.getP_amount() %></small>
							</div>
						</div>
						
						<div class="d-flex justify-content-between border-top p-4">
							<div class="d-flex align-items-center">
								<a class="h3 d-block mb-3" href="AppointmentController?action=confirm&aid=<%=a.getAid()%>&email=<%=patient.getEmail()%>">Confirm</a>
							</div>
							<div class="d-flex align-items-center">
								<a class="h3 d-block mb-3" href="dr-delete-package.jsp?pid=<%=p.getP_id()%>">Reject</a>
							</div>
						</div>
						
						
							
					</div>
				</div>
				<%} %>
			</div>
		</div>
	</div>
	<!-- Blog End -->	
	
	
	
	
	<%
}

%>
</body>
</html>
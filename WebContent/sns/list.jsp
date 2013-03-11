<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	function a() {
		pwd1 = prompt("�н����带 �Է��϶�");
		f.pwd.value = pwd1;
		f.action = "/sns_server/out.do";
		f.submit();
	}
	function b(n, id) {
		if (n == "1") {
			ft.action = "/sns_server/addFr.do?id=" + id;
			ft.submit();
		} else if (n == "2") {
			ft.action = "/sns_server/delFr.do?id=" + id;
			ft.submit();
		}
		//	alert("�߸��� �۵�");
	}
	function c(n) {
		if (n == "1") {
			f.action = "/sns_server/updateForm.do";
		} else if (n == "2") {
			f.action = "/sns_server/logout.do";
		}
		f.submit();
	}
	function d(n, form) {
		if (n == 1) {
			form.action = "/sns_server/editForm.do";
		} else if (n == 2) {
			form.action = "/sns_server/delAr.do";
		}
		form.submit();
	}
</script>
</head>
<body>

	<form action="/sns_server/updateForm.do" method="post" name="f">
		<input type="button" value="����������" onclick="c('1')"> <input
			type="button" value="�α׾ƿ�" onclick="c('2')"> <input
			type="hidden" name="pwd" /> <input type="button" value="Ż��"
			onclick="a()" />
	</form>


	<table border="1">
		<tr>
			<th style="width: 600px;">�۸��</th>
			<th>�θư���</th>
		</tr>
		<tr>
			<td rowspan="3"><a href="/sns_server/writeForm.do">�۾���</a><br />
				<table border="1">
					<tr>
						<th>�۹�ȣ</th>
						<th>�ۼ���</th>
						<th style="width: 300px;">����</th>
						<th>����</th>
					</tr>
					<c:forEach var="a" items="${articles}">
						<tr>
							<td>${a.num}</td>
							<td>${a.writer_id}</td>
							<td>${a.content}</td>
							<td><c:if test="${a.writer_id == sessionScope.id }">
									<form method="post">
										<input type="hidden" name="num" value="${a.num}" /> <input
											type="hidden" name="writer_id" value="${a.writer_id}" /> <input
											type="hidden" name="content" value="${a.content}" /> <input
											type="button" value="����" onclick="d(1, this.form)" /> <input
											type="button" value="����" onclick="d(2, this.form)" />
									</form>
								</c:if></td>
						</tr>
					</c:forEach>
				</table></td>
			<td>
				<h3>�� �� �ִ� ���</h3> <c:forEach var="m" items="${data}">
					<a href="/sns_server/frInfo.do?id=${m.id }">${m.id }</a>
					<br />
				</c:forEach>
			</td>
		</tr>
		<tr>
			<td>
				<h3>�� �θ�</h3>
				<form name="ft" method="post">
					<table border="1">
						<tr>
							<th>������� ģ��</th>
							<th>���� ��û�� ģ��</th>
							<th>ģ��</th>
						</tr>
						<c:forEach var="f" items="${fdata}">
							<tr>
								<td><c:if test="${f.info1 =='no'}">${f.fr_id }
	<input type="button" value="����" onclick="b('1', '${f.fr_id }')" />
										<input type="button" value="����"
											onclick="b('2', '${f.fr_id }')" />
									</c:if></td>
								<td><c:if test="${f.info1 =='my'}">${f.fr_id }
	<input type="button" value="���" onclick="b('2', '${f.fr_id }')" />
									</c:if></td>
								<td><c:if test="${f.info1 =='yes'}">${f.fr_id }</c:if></td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<h3>ģ�� ã��(id�� �˻�)</h3>
				<form action="/sns_server/searchFr.do" method="post">
					<input type="text" name="id" /> <input type="submit" value="�˻�" />
				</form>
			</td>
		</tr>
	</table>

</body>
</html>






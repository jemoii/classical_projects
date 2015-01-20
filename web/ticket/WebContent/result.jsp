<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="me.station.train.Train,java.util.ArrayList,java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.title {
	color: #09F
}
</style>
<title>查询结果</title>
</head>
<body align="center">
	<h1 class="title">查询结果</h1>

	<%
		ArrayList<Train> balance = (ArrayList<Train>) request
				.getAttribute("balance");
		if (balance != null) {
			Iterator<Train> it = balance.iterator();
			Train train = new Train();
	%>
	<table border="1">
		<tr class="title">
			<td>
				<%
					out.print("车次");
				%>
			</td>
			<td>
				<%
					out.print("出发站");
				%>
			</td>
			<td>
				<%
					out.print("到达站");
				%>
			</td>
			<td>
				<%
					out.print("出发时间");
				%>
			</td>
			<td>
				<%
					out.print("到达时间");
				%>
			</td>
			<td>
				<%
					out.print("商务座");
				%>
			</td>
			<td>
				<%
					out.print("特等座");
				%>
			</td>
			<td>
				<%
					out.print("一等座");
				%>
			</td>
			<td>
				<%
					out.print("二等座");
				%>
			</td>
			<td>
				<%
					out.print("高级软卧");
				%>
			</td>
			<td>
				<%
					out.print("软卧");
				%>
			</td>
			<td>
				<%
					out.print("硬卧");
				%>
			</td>
			<td>
				<%
					out.print("软座");
				%>
			</td>
			<td>
				<%
					out.print("硬座");
				%>
			</td>
			<td>
				<%
					out.print("无座");
				%>
			</td>
			<td>
				<%
					out.print("备注");
				%>
			</td>
		</tr>
		<%
			while (it.hasNext()) {
					train = it.next();
		%>
		<tr>
			<%
				if (train.getStation_train_code() != null) {
			%><td>
				<%
					out.print(train.getStation_train_code());
				%>
			</td>
			<%
				}
						if (train.getFrom_station_name() != null) {
			%><td>
				<%
					out.print(train.getFrom_station_name());
				%>
			</td>
			<%
				}
						if (train.getTo_station_name() != null) {
			%><td>
				<%
					out.print(train.getTo_station_name());
				%>
			</td>
			<%
				}
						if (train.getStart_time() != null) {
			%><td>
				<%
					out.print(train.getStart_time());
				%>
			</td>
			<%
				}
						if (train.getArrive_time() != null) {
			%><td>
				<%
					out.print(train.getArrive_time());
				%>
			</td>
			<%
				}
						if (train.getSwz_num() != null) {
			%><td>
				<%
					out.print(train.getSwz_num());
				%>
			</td>
			<%
				}
						if (train.getTz_num() != null) {
			%><td>
				<%
					out.print(train.getTz_num());
				%>
			</td>
			<%
				}
						if (train.getZy_num() != null) {
			%><td>
				<%
					out.print(train.getZy_num());
				%>
			</td>
			<%
				}
						if (train.getZe_num() != null) {
			%><td>
				<%
					out.print(train.getZe_num());
				%>
			</td>
			<%
				}
						if (train.getGr_num() != null) {
			%><td>
				<%
					out.print(train.getGr_num());
				%>
			</td>
			<%
				}
						if (train.getRw_num() != null) {
			%><td>
				<%
					out.print(train.getRw_num());
				%>
			</td>
			<%
				}

						if (train.getYw_num() != null) {
			%><td>
				<%
					out.print(train.getYw_num());
				%>
			</td>
			<%
				}
						if (train.getRz_num() != null) {
			%><td>
				<%
					out.print(train.getRz_num());
				%>
			</td>
			<%
				}
						if (train.getYz_num() != null) {
			%><td>
				<%
					out.print(train.getYz_num());
				%>
			</td>
			<%
				}
						if (train.getWz_num() != null) {
			%><td>
				<%
					out.print(train.getWz_num());
				%>
			</td>
			<%
				}
						if (train.getCanWebBuy()!= null) {
			%><td>
				<%
					out.print("<a href=\"https://kyfw.12306.cn/otn/leftTicket/init\">预订>></a>");
				%>
			
		</tr>
		<%
			}

				}

			} else {

				out.println("查询条件错误，请重试！");

			}
		%>



	</table>
</body>
</html>
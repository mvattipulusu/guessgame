<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Number Guessing</title>
<style type="text/css">
body { {
	width: 400px;
}

}
label { {
	width: 120px;
	display: block;
	float: left;
}
}
</style>
</head>
<body>
	<h1>Guess a Number (1-20)</h1>
	<c:choose>
		<c:when test="${counter <= chances }">
			<form action="guess">
				<div>
					<label for="guess">Number:</label> <input type="number"
						name="guessNo" size="3" autofocus="autofocus" required="required"
						min="1" max="20" maxlength="2" />
				</div>
				<br /> <input type="submit" />
			</form>
			<h4>You have ${chances - counter} chances to play</h4>
			<c:if test="${counter > 0}">
				<p>[Guess ${guessNo}]: ${message}</p>
			</c:if>

		</c:when>
		<c:otherwise>
			<h3>Sorry your attempts are over.</h3>
			<h4>
				Click <a href="resetCounter">here</a> if you want to retry.
			</h4>
		</c:otherwise>

	</c:choose>
	
</body>
</html>
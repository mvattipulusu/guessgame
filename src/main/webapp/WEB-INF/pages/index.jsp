<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
    <head>
        <title>Number Guessing</title>
        <style type="text/css">
            body {{ width: 400px; }}
            label {{ width: 120px; display: block; float: left; }}
        </style>
    </head>
    <body>
       <h1>Guess a Number (1-20)</h1>
        <c:choose>
		<c:when test="${counter >= 0 && counter < 5 }">
        <form action="guess">
            <div>
                <label for="guess">Number:</label>
                <input type="number" name="guessNo" size="3" autofocus="autofocus" required="required" min="1" max="20" maxlength="2"/>
            </div>
            <br/>
           		<input type="submit"/>
        </form>
 		  <h4>You have ${5 - counter} chances to play</h4>
         <c:if test="${counter > 0 && guessNo < randomNumber}">
				<p>[Guess ${guessNo}]: Your number is too small!</p>
			</c:if>
 			<c:if test="${counter > 0 && guessNo > randomNumber}">
				<p>[Guess ${guessNo}]: Your number is too large!</p>
			</c:if>
			<c:if test="${counter > 0 && guessNo == randomNumber}">
				<p>Congratulations! You guessed the right number with
                ${counter} tries.</p>
                <p>Click <a href="resetCounter">here</a> if you want to re-play.</p>
			</c:if>
        </c:when>
        <c:otherwise>
        	<h3>Sorry your attempts are over.</h3>
        	<h4>Click <a href="resetCounter">here</a> if you want to retry.</h4>
        </c:otherwise>
        </c:choose>
    </body>
</html>
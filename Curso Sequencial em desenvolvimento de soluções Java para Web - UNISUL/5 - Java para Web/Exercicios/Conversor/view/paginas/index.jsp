<html>
<head>
	<LINK REL=stylesheet HREF="css/style.css" TYPE="text/css">
<title>Conversor de Unidades</title>
</head>
<body>

<h1>Conversor de Unidades</h1>

<form method="post" action="redirecionador">
<table border="1">
	<tr>
		<td>
		<table>
			<tr>
				<td>Centímetro - Metro</td>
				<td><input type="radio" name="rconversor" value="cm-m"></td>
			</tr>
			<tr>
				<td>Metro - Quilômetro</td>
				<td><input type="radio" name="rconversor" value="m-km"></td>
			</tr>
			<tr>
				<td>Quilômetro - Metro</td>
				<td><input type="radio" name="rconversor" value="km-m"></td>
			</tr>
		</table>
		</td>
		
		<td>
		<table>
			<tr>
				<td>Grama - Quilo</td>
				<td><input type="radio" name="rconversor" value="g-kg"></td>
			</tr>
			<tr>
				<td>Quilo - Tonelada</td>
				<td><input type="radio" name="rconversor" value="kg-ton"></td>
			</tr>
			<tr>
				<td>Tonelada - Grama</td>
				<td><input type="radio" name="rconversor" value="ton-g"></td>
			</tr>
		</table>
		</td>
		
		<td>
		<table>
			<tr>
				<td>Segundo - Minuto</td>
				<td><input type="radio" name="rconversor" value="seg-min"></td>
			</tr>
			<tr>
				<td>Minuto - Hora</td>
				<td><input type="radio" name="rconversor" value="min-hor"></td>
			</tr>
			<tr>
				<td>Hora - Segundo</td>
				<td><input type="radio" name="rconversor" value="hor-seg"></td>
			</tr>
		</table>
		</td>
	</tr>

	<tr>
		<td>
		<table>
			<tr>
				<td>Real - Dolar</td>
				<td><input type="radio" name="rconversor" value="real-dolar"></td>
			</tr>
			<tr>
				<td>Real - Euro</td>
				<td><input type="radio" name="rconversor" value="real-euro"></td>
			</tr>
			<tr>
				<td>Real - Libra</td>
				<td><input type="radio" name="rconversor" value="real-libra"></td>
			</tr>
		</table>
		</td>
		
		<td>
		<table>
			<tr>
				<td>Celcius - Fahrenheit</td>
				<td><input type="radio" name="rconversor" value="celcius-fahr"></td>
			</tr>
			<tr>
				<td>Celcius - Kelvin</td>
				<td><input type="radio" name="rconversor" value="celcius-kelvin"></td>
			</tr>
		</table>
		</td>
		
		<td>
		<table>	
			<tr>
				<td>Byte - KByte</td>
				<td><input type="radio" name="rconversor" value="byte-kb"></td>
			</tr>
			<tr>
				<td>KByte - MegaByte</td>
				<td><input type="radio" name="rconversor" value="kb-mb"></td>
			</tr>
			<tr>
				<td>MegaByte - GigaByte</td>
				<td><input type="radio" name="rconversor" value="mb-gb"></td>
			</tr>
			<tr>
				<td>GigaByte - TeraByte</td>
				<td><input type="radio" name="rconversor" value="gb-tb"></td>
			</tr>
		</table>
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			Valor: <input type="text" name="value">
		</td>
		<td align="center">
			<input type="submit" value="Efetuar Conversão">
		</td>
	</tr>
		
</table>
</form>

<br><br><br><br><br><br><br><br><br><br><br><br><br>

<address>
	<p>created by <a href="mailto:fabiodelabruna@hotmail.com">Fabio Dela Bruna</a> - copyright(c) 2009</p>
</address>

</body>
</html>
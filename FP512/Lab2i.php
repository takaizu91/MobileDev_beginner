<html>
<head>
<title> Assignment Operators </title>
</head>

<body>
<?php
	$a = 42;
	$b = 20;
	
	$c = $a + $b;		//Assignment Operator
	echo "Addition Operation Result: $c <br />";
	
	$c += $a;		// c value was 42 + 20 = 62
	echo "Add AND Assignment Operation Result: $c <br />";
	
	$c -= $a;		// c value was 42 + 20 + 42 = 104
	echo "Substract AND Assignment Operation Result: $c <br />";
	
	$c *= $a;		// c value was 104 - 42 = 64
	echo "Multiply AND Assignment Operation Result: $c <br />";
	
	$c /= $a;		// c value was 62 * 42 = 2604
	echo "Division AND Assignment Operation Result: $c <br />";
	
	$c %= $a;		// c value was 2604 / 42 = 62
	echo "Modulus AND Assignment Operation Result: $c <br />";
?>
</body>
</html>

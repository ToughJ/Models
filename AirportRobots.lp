\ENCODING=ISO-8859-1
\Problem name: ilog.cplex

Minimize
 obj: 120 x0 + 252 y0 + 120 x1 + 252 y1 + 120 x2
Subject To
 c1: x0 + y0 >= 34
 c2: x0 + y0 + x1 + y1 >= 34
 c3: y0 + x1 + y1 + x2 >= 17
 c4: y0 + x1 >= 17
Bounds
 0 <= x0 <= 34
 0 <= y0 <= 34
 0 <= x1 <= 34
 0 <= y1 <= 34
 0 <= x2 <= 34
Generals
 x0  y0  x1  y1  x2 
End

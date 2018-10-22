\ENCODING=ISO-8859-1
\Problem name: ilog.cplex

Minimize
 obj: 120 x0 + 120 x3 + 252 y0 + 252 y2 + 252 y3 + 120 x1 + 252 y1 + 120 x2
Subject To
 c1: x0 + x3 + y0 + y2 + y3 >= 34
 c2: x0 + y0 + y3 + x1 + y1 >= 34
 c3: y0 + y2 + x1 + y1 + x2 >= 17
 c4: x3 + y2 + y3 + y1 + x2 >= 17
Bounds
 0 <= x0 <= 34
 0 <= x3 <= 34
 0 <= y0 <= 34
 0 <= y2 <= 34
 0 <= y3 <= 34
 0 <= x1 <= 34
 0 <= y1 <= 34
 0 <= x2 <= 34
Generals
 x0  x3  y0  y2  y3  x1  y1  x2 
End

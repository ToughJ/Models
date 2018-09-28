\ENCODING=ISO-8859-1
\Problem name: ilog.cplex

Minimize
 obj: xa1 + xb1 + xc1 + xd1
Subject To
 c1: 1.012 xa1 - xa2  = 0
 c2: 1.012 xa2 + 1.035 xb1 - xa3 - xb3  = 50000
 c3: 1.012 xa3 + 1.058 xc1 - xa4 - xc4  = 0
 c4: 1.035 xb3 + 1.012 xa4 - xa5 - xb5  = 50000
 c5: 1.012 xa5 - xa6  = 0
 c6: 1.058 xc4 + 1.035 xb5 + 1.012 xa6 + 1.11 xd1 >= 200000
Bounds
 0 <= xa1 <= 300000
 0 <= xa2 <= 300000
 0 <= xb1 <= 300000
 0 <= xa3 <= 300000
 0 <= xb3 <= 300000
 0 <= xc1 <= 300000
 0 <= xa4 <= 300000
 0 <= xc4 <= 300000
 0 <= xa5 <= 300000
 0 <= xb5 <= 300000
 0 <= xa6 <= 300000
 0 <= xd1 <= 300000
End

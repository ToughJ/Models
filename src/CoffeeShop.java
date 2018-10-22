import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class CoffeeShop {

	public static void main(String[] args) throws IloException {
		doModel();
	}
	
	private static void doModel() throws IloException {
		IloCplex model = new IloCplex();
		IloNumVar[] xa = new IloNumVar[6];
		IloNumVar[] xb = new IloNumVar[3];
		IloNumVar[] xc = new IloNumVar[2];
		
		for (int i = 0; i < 6; i++) {
			xa[i] = model.numVar(0, 300000, "xa"+(i+1));
			switch (i) {
			case 0:
				xb[0] = model.numVar(0, 300000, "xb"+(i+1));
				xc[0] = model.numVar(0, 300000, "xc"+(i+1));
				break;
			case 2:
				xb[1] = model.numVar(0, 300000, "xb"+(i+1));
				break;
			case 3:
				xc[1] = model.numVar(0, 300000, "xc"+(i+1));
				break;
			case 4:
				xb[2] = model.numVar(0, 300000, "xb"+(i+1));
				break;
			}
		}
		
		IloNumVar xd = model.numVar(0, 300000, "xd1");
		IloLinearNumExpr[] y = new IloLinearNumExpr[7]; 
		for (int i = 0; i <= 6; i++) 
			y[i] = model.linearNumExpr();
		
		y[0].addTerm(1.0, xa[0]);  y[0].addTerm(1.0, xb[0]); 
		y[0].addTerm(1.0, xc[0]);  y[0].addTerm(1.0, xd);
		
		y[1].addTerm(1.012, xa[0]);
		model.addEq(y[1], xa[1]);
		
		y[2].addTerm(1.012, xa[1]);  y[2].addTerm(1.035, xb[0]);
		model.addEq(y[2], model.sum(50000, model.sum(xa[2], xb[1])));
		
		y[3].addTerm(1.012, xa[2]);  y[3].addTerm(1.058, xc[0]);
		model.addEq(y[3], model.sum(xa[3], xc[1]));
		
		y[4].addTerm(1.012, xa[3]);  y[4].addTerm(1.035, xb[1]);
		model.addEq(y[4], model.sum(50000, model.sum(xa[4], xb[2])));
		
		y[5].addTerm(1.012, xa[4]); 
		model.addEq(y[5], xa[5]);
		
		y[6].addTerm(1.012, xa[5]);  y[6].addTerm(1.035, xb[2]);
		y[6].addTerm(1.058, xc[1]);  y[6].addTerm(1.11, xd);
		model.addGe(y[6], 200000);
		
		model.addMinimize(y[0]);
		
		model.exportModel("CoffeeShop.lp");
		model.solve();
		System.out.println("obj: " + model.getObjValue());
	}
}

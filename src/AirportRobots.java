

import ilog.concert.IloException;
import ilog.concert.IloLinearNumExpr;
import ilog.concert.IloNumVar;
import ilog.cplex.IloCplex;

public class AirportRobots {
	
	public static void main(String[] args) throws IloException {
		doModel();
	}

	private static void doModel() throws IloException {
		IloCplex model = new IloCplex();
		IloNumVar[] x = new IloNumVar[4];
		IloNumVar[] y = new IloNumVar[4];
		for (int i = 0; i < 4; i++)
			x[i] = model.intVar(0, 34,"x"+i);
		for (int i = 0; i < 4; i++)
			y[i] = model.intVar(0, 34,"y"+i);
		model.addGe(model.sum(x[0],x[3],y[0],y[2],y[3]), 34);
		model.addGe(model.sum(x[0],y[0],x[1],y[1],y[3]), 34);
		model.addGe(model.sum(x[1],y[0],x[2],y[1],y[2]), 17);
		model.addGe(model.sum(x[2],x[3],y[1],y[2],y[3]), 17);
		IloLinearNumExpr e = model.linearNumExpr();;
		for (int i = 0; i < 4; i++)
			e.addTerm(120, x[i]);
		for (int i = 0; i < 4; i++)
			e.addTerm(252, y[i]);
		model.addMinimize(e);
		model.exportModel("AirportRobots.lp");
		model.solve();
		System.out.println("obj: " + model.getObjValue());
	}
}



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
		IloNumVar[] x = new IloNumVar[3];
		IloNumVar[] y = new IloNumVar[2];
		for (int i = 0; i < 3; i++)
			x[i] = model.intVar(0, 34,"x"+i);
		for (int i = 0; i < 2; i++)
			y[i] = model.intVar(0, 34,"y"+i);
		model.addGe(model.sum(x[0],y[0]), 34);
		model.addGe(model.sum(model.sum(x[0], y[0]), model.sum(x[1],y[1])), 34);
		model.addGe(model.sum(model.sum(x[1], y[0]), model.sum(x[2],y[1])), 17);
		model.addGe(model.sum(x[1],y[0]), 17);
		IloLinearNumExpr e = model.linearNumExpr();;
		for (int i = 0; i < 3; i++)
			e.addTerm(120, x[i]);
		for (int i = 0; i < 2; i++)
			e.addTerm(252, y[i]);
		model.addMinimize(e);
		model.exportModel("AirportRobots.lp");
		model.solve();
		System.out.println("obj: " + model.getObjValue());
	}
}

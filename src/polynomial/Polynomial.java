package polynomial;

public class Polynomial {
	Term term; 
	Polynomial nextPol;

	// punto 1:
	public Polynomial() {
		this.term=new Term(0,0);
		this.nextPol=null;
	}

	// punto 2:
	public Polynomial(int coef[]) {
		this.term=new Term(0,0);
		this.nextPol=null;
		Polynomial currentTerm=this;
		for (int i=coef.length-1;i!=-1;i--) {
                    if (coef[i]==0) {
                        continue;
                    }
                    currentTerm.term=new Term(coef[i],i+1);
                    if (i!=0) {
                    currentTerm=step(currentTerm);
                    }
		}
	}

	// punto 3
	public Polynomial add (Polynomial pol) {
		Polynomial res = new Polynomial();
		Polynomial resCurrentTerm=res;
		Polynomial thisCurrentTerm=this;
		Polynomial polCurrentTerm;
		if (pol==null&&this!=null) {
                    return this;
		}
		if (pol!=null&this==null) {
                    return pol;
		}
		while (thisCurrentTerm!=null) {
                        polCurrentTerm=pol;
			resCurrentTerm.term=new Term(thisCurrentTerm.term.coef,thisCurrentTerm.term.exp);
			while (polCurrentTerm!=null){
                            Term aux = resCurrentTerm.term;
                            while (!isIn(this,polCurrentTerm.term.exp)&&!isIn(res,polCurrentTerm.term.exp)) {
                                resCurrentTerm.term=new Term(polCurrentTerm.term.coef,polCurrentTerm.term.exp);
                                polCurrentTerm=polCurrentTerm.nextPol;
                                resCurrentTerm=step(resCurrentTerm);
                                resCurrentTerm.term=aux;
                            }
                            if (polCurrentTerm.term.exp==thisCurrentTerm.term.exp) {
                                resCurrentTerm.term.coef+=polCurrentTerm.term.coef;
                                polCurrentTerm=polCurrentTerm.nextPol;
                            } else {
                                polCurrentTerm=polCurrentTerm.nextPol;
                            }
			}
			thisCurrentTerm=thisCurrentTerm.nextPol;
                        if (thisCurrentTerm!=null) {
			resCurrentTerm=step(resCurrentTerm);
                        }
		} 
		return res;
	}

	// iterator
	public Polynomial step(Polynomial p) {
		p.nextPol=new Polynomial();
		return p.nextPol;
	}

	/* metodo auxiliar, toma un polinomio y un exponente,
	y devuelve true si dicho exponente esta en el polinomio,
	 de lo contrario devuelve false. */
	public boolean isIn(Polynomial pol,int exp){
		boolean res= false;
		Polynomial currentTerm = pol;
		while(currentTerm!=null) {
		if (currentTerm.term.exp==exp) {
			return true;
		}
		currentTerm=currentTerm.nextPol;
	}
		return res;
	}

	// punto 4:
	public int getCoefficient(int x) {
		int res=0;
		Polynomial currentTerm=this;
		while(currentTerm!=null){
			if (currentTerm.term.exp==x) {
				res=currentTerm.term.coef;
			}
			currentTerm=currentTerm.nextPol;
		}
		return res;
	}

	// punto 5:
	public void setCoefficient(int x,int coef) {
		Polynomial pol=this;
		while (pol!=null) {
			if (pol.term.exp==x) {
				pol.term.coef=coef;
			}
			pol=pol.nextPol;
		}
	}

	// punto 6:
	public int valueOf(float x) {
		double res=0;
		Polynomial pol=this;
		while (pol!=null) {
			res+=(pol.term.coef*Math.pow(x,pol.term.exp));
			pol=pol.nextPol;
		}
		return (int)res;
	}

	//punto 7
        @Override
	public boolean equals(Object x) {
		if (!(x instanceof Polynomial)) {
			return false;
		}
                Polynomial o = (Polynomial) x;
		if (this.sizeOf()!=o.sizeOf()){
			return false;
		}
		boolean res=true;
		Polynomial pol=this;
		Polynomial obj=o;
		while(pol!=null){
                    if (!(pol.term.coef==obj.term.coef&&pol.term.exp==obj.term.exp)) {
                        return false;
                    } 
                    pol=pol.nextPol;
                    obj=obj.nextPol;
		}
		return res;
	}
	/*metodo auxiliar para calcular el tamanio de un polinomio segun
	sus terminos y facilitar la comparacion entre polinomios.*/
	public int sizeOf(){
		Polynomial pol=this;
		int i=0;
		while(pol!=null){
			i++;
			pol=pol.nextPol;
		}
		return i;
	}

	// punto 8
       
        @Override
	public String toString() {
		Polynomial pol=this;
		String res="";
		while(pol!=null) {
			if (pol.nextPol!=null) {
				res= res + String.valueOf(pol.term.coef)+ "*x^"+String.valueOf(pol.term.exp)+"+";
			} else {
				res= res + String.valueOf(pol.term.coef)+ "*x^"+String.valueOf(pol.term.exp);
			}
			pol=pol.nextPol;
		}
		return res;
	} 
}
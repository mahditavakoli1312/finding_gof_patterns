public aspect SecurityAspect{
	pointcut uidAuth(int uid) : (call(public void Business.doSomeWorkWithUser(int)) && args(uid)) 
						|| (execution(public void Business.set*(int, ..)) && args(uid, *));
	// Proč jedno musí být call a druhý execution to netuším, ale takto to funguje :) Pokud by místo set* bylo jen *, tak můžou být dvě call
	// Jinak to vyhazuje: ambiguous binding of parameter(s) uid across '||' in pointcut

	Object around(int uid) : uidAuth(uid) {
		if(uid == 0){
			return proceed(uid);
		}else{
			System.out.println("\tSystem prevented action ("+
						thisJoinPoint.getTarget().getClass().getName() + "." +
						thisJoinPoint.getSignature().getName()
						+") for user with uid = "+uid);
			return null;
		}
	}
}

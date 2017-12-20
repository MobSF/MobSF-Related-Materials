

public class BreakVault {
	public static void main(String args[]){

		String hashStr = "46792755";
		String pinStr;
		long pin = 0 ;
		boolean pinfound = false;
		long startTime = System.currentTimeMillis();
		
		 for(long i=0;i<=999999;i++){
			try{
				pinStr = String.format("%05d", i);
				if(pinStr.hashCode() == Integer.parseInt(hashStr)){
					pin = i;
					pinfound = true;
					break;
				}
			}catch(Exception e){
				e.printStackTrace();
			}

		}

		if(pinfound){
			System.out.println("The PIN is: "+ String.format("%05d",pin));
		}else{
			System.out.println("The pin could not be found");
			
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("Time to Crack: " + (endTime - startTime) + " milliseconds");

	}
}

package Hair;
import java.util.*;
import java.io.*;

public class Test{
	public static void main(String[] args) throws IOException {
		Hair[] head = new Hair[100000]; /**sets up an array of Hair*/
		double timestep = 1.0/365.0; /**timestep = 1 day*/
		double simuTime = Double.parseDouble(args[0]); /**simulation time in years*/
		/**simulate the head!*/
		for (int i = 0; i < head.length; i++) {
			head[i] = new Hair();
                }
		double deadCount = 0;
		for (double t = 0; t < simuTime; t = t + timestep) {
			for (int i = 0; i < head.length; i++) {
				Hair h = head[i];
				h.grow(timestep);
				if (!h.isAlive()) {
					head[i] = new Hair();
					deadCount = deadCount + 1;
				}		
			}
		}
		System.out.println("average fallen hair per day: " + deadCount/(simuTime*365));
		double averageLength = 0;
		for (int i = 0; i < head.length; i++) {
                        averageLength += head[i].getLength();
                }
		averageLength = averageLength/(double)head.length;
		System.out.println("average length: " + averageLength);
		/**FileWriter f = new FileWriter("hairlength.txt");
		for (int i = 0; i < head.length; i++) {
			f.write(head[i].getLength() + "\n");
		}
		f.close();
		double[][] histo = lengthHisto(head, 1, 100);
		for (int i = 0; i < histo.length; i++ ) {
			System.out.println(histo[i][0] + " " + histo[i][1]);
		}*/
	}

	public static double[][] lengthHisto(Hair[] head, double binSize, double range) {
		int nBin = (int)(range/binSize);
		double[][] result = new double[nBin][2];
		for (int i = 0; i < nBin; i++) {
			result[i][0] = (0.5 + (double)i)*binSize;
			result[i][1] = 0;
		}
		Hair h;
		for (int i = 0; i < head.length; i++) {
                        h = head[i];
			int binToEnter = (int)(h.getLength()/binSize);
			if (binToEnter <= nBin) {
				result[binToEnter][1] = result[binToEnter][1] + 1.0;
			}
		}
		for (int i = 0; i < nBin; i++) {
                        result[i][1] = result[i][1]/((double)head.length*binSize);
                }
                return result;
	}
}

	

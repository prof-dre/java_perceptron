import java.util.Arrays;

/**
 * An in-class demonstration of a simple perceptron
 * with four inputs.
 * 
 * @author Andre M. Maier
 * @version 1.0
 */
public class Demo {
  
   public static void main( String[] args ) {

      // Create a perceptron with four inputs
      Perceptron perceptron = new Perceptron( 4 );

      double[][] inputs = {{ 1, 0, 1, 0 }, 
	                   { 0, 1, 0, 1 }, 
			   { 1, 1, 1, 1 }, 
			   { 0, 0, 0, 0 }};

      int[] labels = { 1, 1, 1, 0 };

      // Train the perceptron with a learning rate of 0.1 and
      // 100 epochs
      perceptron.train( inputs, labels, 0.1, 100 );

      // Test the perceptron on a sample input vector
      double[] testInput = { 1, 0, 1, 0 };
      int prediction = perceptron.predict( testInput );

      String weightsAsStr = Arrays.toString( perceptron.getWeights() );
      System.out.println( "Weights: " + weightsAsStr ) ;
      System.out.println( "Bias: " + perceptron.getBias() );
      System.out.println( "Test input: " + Arrays.toString( testInput ));
      System.out.println( "Prediction: " + prediction );

   }
}


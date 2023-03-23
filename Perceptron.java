import java.util.Arrays;

/**
 * A simple perceptron with an arbitrary number of inputs
 * and a heaviside activation function.
 *
 * @author Andre M. Maier
 * @version 1.0
 */
public class Perceptron {

   private double[] weights;
   private double bias;
  
   public Perceptron( int numInputs ) {

       // Initialize weights and bias randomly
       weights = new double[ numInputs ];

       for( int i = 0; i < numInputs; i++ )
          weights[ i ] = Math.random();

       bias = Math.random();
   }

   public int predict( double[] inputs ) {

      // Compute the weighted sum of all inputs and add bias
      double weightedSum = 0;
      for( int i = 0; i < inputs.length; i++ )
         weightedSum += inputs[ i ] * weights[ i ];
      weightedSum += bias;

      // Apply the heaviside activation function
      return weightedSum > 0 ? 1 : 0;
   }

   public void train( double[][] inputs, int[] labels, double learningRate,
		      int numEpochs ) {

      for( int epoch = 0; epoch < numEpochs; epoch++ ) {
         for( int i = 0; i < inputs.length; i++ ) {
            double[] x = inputs[ i ];
            int y = labels[ i ];
            int yHat = predict( x );
            double error = y - yHat;
            for( int j = 0; j < weights.length; j++ ) {
               weights[ j ] += learningRate * error * x[ j ];
            }
            bias += learningRate * error;
         }
      }
   }

   public double[] getWeights() {
      return weights;
   }

   public double getBias() {
      return bias;
   }
  
}


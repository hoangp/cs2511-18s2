package tut12.smells.example3;

public class InsuranceQuote {
  private Motorist motorist;

  public InsuranceQuote(Motorist m) {
    this.motorist = m;
  }

  public RiskFactor calculateMotoristRisk() {
    if (motorist.getPointsOnLicense() > 3 || motorist.getAge() < 25) {
      return RiskFactor.HIGH;
    }
    if (motorist.getPointsOnLicense() > 0) {
      return RiskFactor.MEDIUM;
    }
    return RiskFactor.LOW;
  }
  
  /* What Code Smell here ? 
  Fix code smell: Switch statements
  1.  Extract each return value into its own method
  2.  Get each of these methods into their own classes
  3.  Once methods are moved into their own classes, 
      make the method names more generic 
  4.  Extract a common interface for all of them
  5.  Use the interface and appropriate concrete classes to replace the switch
 */
  public double calculateInsurancePremium(double insuranceValue) {
    RiskFactor riskFactor = calculateMotoristRisk();
    switch (riskFactor) {
    case LOW:
      return insuranceValue * 0.02;
    case MEDIUM:
      return insuranceValue * 0.04;
    default:
      return insuranceValue * 0.06;
    }
  }
}

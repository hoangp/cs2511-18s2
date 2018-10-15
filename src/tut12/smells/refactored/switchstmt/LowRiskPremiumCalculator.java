package tut12.smells.refactored.switchstmt;

public class LowRiskPremiumCalculator implements PremiumCalculator {

	@Override
	public double calculatePremium(double insuranceValue) {
		return insuranceValue * 0.02;
	}

}

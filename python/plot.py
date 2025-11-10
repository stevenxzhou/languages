import numpy as np
import matplotlib.pyplot as plt

# Generate 1000 samples from a standard normal distribution
samples = np.random.normal(loc=0.0, scale=1.0, size=1000)

# Plot histogram
plt.hist(samples, bins=30, density=True, alpha=0.6, color='skyblue')

# Overlay the theoretical normal curve
from scipy.stats import norm
x = np.linspace(-4, 4, 100)
plt.plot(x, norm.pdf(x, loc=0.0, scale=1.0), 'r-', lw=2)

plt.title('Normal Distribution (μ=0, σ=1)')
plt.xlabel('Value')
plt.ylabel('Density')
plt.grid(True)
plt.show()
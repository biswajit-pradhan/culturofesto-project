import React, { useState, useEffect } from "react";

const FoodingSystem = () => {
  const [adults, setAdults] = useState(0);
  const [children, setChildren] = useState(0);
  const [foodChoices, setFoodChoices] = useState([]);

  const handleAdultChange = (event) => {
    setAdults(parseInt(event.target.value));
  };

  const handleChildChange = (event) => {
    setChildren(parseInt(event.target.value));
  };

  const handleFoodChoiceChange = (personIndex, foodIndex, isChecked) => {
    const updatedFoodChoices = [...foodChoices];
    updatedFoodChoices[personIndex][foodIndex] = isChecked;
    setFoodChoices(updatedFoodChoices);
  };

  const calculateTotalPrice = () => {
    const childPrice = 10; // Price for each child
    const adultPrice = childPrice * 1.05; // 5% higher price for adults

    let totalPrice = 0;

    for (let i = 0; i < foodChoices.length; i++) {
      const personFoodChoices = foodChoices[i];
      if (i < adults) {
        totalPrice += adultPrice * personFoodChoices.filter(Boolean).length;
      } else {
        totalPrice += childPrice * personFoodChoices.filter(Boolean).length;
      }
    }

    return totalPrice.toFixed(2);
  };

  const renderFoodChoiceInputs = () => {
    const inputs = [];

    for (let i = 0; i < adults + children; i++) {
      const personType = i < adults ? "Adult" : "Child";
      const personNumber = i < adults ? i + 1 : i - adults + 1;

      const personFoodChoices = foodChoices[i] || []; // Ensure foodChoices[i] is an array

      for (let j = 0; j < 3; j++) {
        personFoodChoices[j] = personFoodChoices[j] || false; // Ensure personFoodChoices[j] is initialized to false if undefined
      }

      inputs.push(
        <div key={i}>
          <p>
            {personType} {personNumber} Food Choices:
          </p>
          {personFoodChoices.map((isChecked, foodIndex) => (
            <label key={foodIndex}>
              <input
                type="checkbox"
                checked={isChecked}
                onChange={(event) =>
                  handleFoodChoiceChange(i, foodIndex, event.target.checked)
                }
              />
              {foodIndex === 0
                ? "Breakfast"
                : foodIndex === 1
                ? "Lunch"
                : "Dinner"}
            </label>
          ))}
        </div>
      );
    }

    return inputs;
  };

  useEffect(() => {
    const newFoodChoices = [];

    for (let i = 0; i < adults + children; i++) {
      newFoodChoices.push(foodChoices[i] || []);
    }

    setFoodChoices(newFoodChoices);
  }, [adults, children]);

  return (
    <div>
      <h2>Fooding System</h2>

      <div>
        <label>
          Number of Adults:
          <input type="number" value={adults} onChange={handleAdultChange} />
        </label>
      </div>

      <div>
        <label>
          Number of Children:
          <input type="number" value={children} onChange={handleChildChange} />
        </label>
      </div>

      {renderFoodChoiceInputs()}

      <div>
        <h3>Total Price</h3>
        <p>${calculateTotalPrice()}</p>
      </div>
    </div>
  );
};

export default FoodingSystem;

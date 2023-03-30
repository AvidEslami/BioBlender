https://devpost.com/software/bioblender

## Inspiration
- We wanted to find a better a way to explore the variety of living things around us in a fun and interactive way! 

## What it does
- BioBlender takes any two user inputted animals and returns an informational page on an animal with traits similar to both of the inputted animals. 
- The information gathering is sourced from the OpenAi-API.

## How we built it
- This app was developed using primarily Android-Studio 
- **General Flow:** Take in user animal inputs (or random animal) → Make an OpenAi-API call to determine unique traits pertaining to each animal → Comparison algorithm is ran to create an API call prompt that returns a unique animal each time → OpenAi-API call is made to discover interesting facts pertaining to the newly discovered animal → Make a SerpApi call to receive a random popular image URL of 'X' animal from google → Display all animal information onto the final information page.

## What's next for BioBlender
- Game Mode (combining a list of randomly generated animals with the goal of reaching an imposed destination animal), Game Mode could also include an achievement system which would give the user in-app rewards for meeting certain criteria with their pool of generated animals (eg: 10 animals from South America, or 5 animals that have sharp claws).
- Save feature to save the generated information page for unique and interesting animals.

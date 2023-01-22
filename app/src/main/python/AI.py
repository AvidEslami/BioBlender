import openai
import random
import time

OPENAI_API_KEY = "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"
openai.api_key = OPENAI_API_KEY

animals = []

def set_animal(animal_string):
    animals = animal_string.split(" ")

def addAnimal(new_animal):
    new_animal = new_animal.replace("\n", "")
    new_animal = new_animal.replace(".", "")
    if new_animal not in animals:
        animals.append(new_animal)

def compareAnimals(animal_1, animal_2):

    traits1 = openai.Completion.create(
        model="text-davinci-003",
        prompt="Provide 2 random traits associated with a "+animal_1+"",
        max_tokens=2048,
        temperature=0
    )

    traits2 = openai.Completion.create(
        model="text-davinci-003",
        prompt="Provide 2 random traits associated with a "+animal_2+"",
        max_tokens=2048,
        temperature=0
    )

    all_traits = traits1.choices[0].text + traits2.choices[0].text
    traits = random.sample(all_traits, 2)
    animal_blend = ""
    while True:
        prefix = random.choice(["ocean", "less known", "prehistoric", "rare", "endangered", "insect", "exotic", ""])
        new_animal = openai.Completion.create(
            model="text-davinci-003",
            prompt="Name an "+prefix+" animal that has the personality traits: " + traits[0] + " and " + traits[1] +". The animal should not be in the list: "+" ".join(animals[0:15])+". Only name the animal and do not give a description.",
            max_tokens=2048,
            temperature=0
        )
        animal_blend = new_animal.choices[0].text
        animal_blend = animal_blend.replace("\n", "")
        animal_blend = animal_blend.replace(".", "")
        if animal_blend not in animals:
            break
        print("Combined Dup: "+animal_blend)
        time.sleep(2)

    addAnimal(animal_blend)
    return animal_blend.replace("\n", "")

def generateAnimal():
    txt = ""
    while True:
        prefix = random.choice(["ocean", "less known", "prehistoric", "rare", "endangered", "insect", "exotic", ""])
        response = openai.Completion.create(
            model="text-davinci-003",
            prompt="Provide a random "+prefix+" animal that is not any of the following: ["+" ".join(animals[0:15])+"]. Only name the animal and DO NOT give a description.",
            max_tokens=2048,
            temperature=0
        )
        txt = response.choices[0].text
        txt = txt.replace("\n", "")
        txt = txt.replace(".", "")
        if txt not in animals:
            break
        print("Generated Dup: "+txt)
        time.sleep(2)

    addAnimal(txt)
    return txt.replace("\n", "")

def check_animal(animal):
    response = openai.Completion.create(
        model="text-davinci-003",
        prompt="is a "+animal+" an animal? Type [yes] if yes, otherwise type [no]",
        max_tokens=2048,
        temperature=0
    )
    txt = response.choices[0].text
    txt = txt.replace("\n", "")
    print(txt)
    if txt.lower() == "yes": return True
    else: return False

def explain_why(animal_1, animal_2, result):
    traits1 = openai.Completion.create(
        model="text-davinci-003",
        prompt="Provide 2 random traits associated with a "+animal_1+"",
        max_tokens=2048,
        temperature=0
    )

    traits2 = openai.Completion.create(
        model="text-davinci-003",
        prompt="Provide 2 random traits associated with a "+animal_2+"",
        max_tokens=2048,
        temperature=0
    )

    all_traits = traits1.choices[0].text + traits2.choices[0].text
    traits = random.sample(all_traits, 2)

    while True:
        prefix = random.choice(["ocean", "unique", "less known", "rare", "exotic", "interesting", "", "", ""])
        new_animal = openai.Completion.create(
            model="text-davinci-003",
            prompt="Name an "+prefix+" animal that has the personality traits: " + traits[0] + " and " + traits[1] +". The animal should not be in the list: "+" ".join(animals)+". Only name the animal and DO NOT give a description.",
            max_tokens=2048,
            temperature=0
        )
        animal_blend = new_animal.choices[0].text.replace("\n", "")
        if animal_blend not in animals:
            break
        time.sleep(2)

    addAnimal(animal_blend)
    return animal_blend.replace("\n", "")

def get_animals():
    return " ".join(animals)

def generate_description(animal):
    response = openai.Completion.create(
        model="text-davinci-003",
        prompt="Provide 5-10 interesting facts about a "+animal+" in point form. One line space between each point.",
        max_tokens=2048,
        temperature=0
    )
    return response.choices[0].text

while(True):
    print("Generating 3 random Animals:")
    animal1 = generateAnimal()
    animal2 = generateAnimal()
    print("Animal 1: "+animal1)
    print("Animal 2: "+animal2)
    print("Animal 3: "+generateAnimal())
    animal4 = compareAnimals(animal1,animal2)
    print("Combining Animal  1 and 2: "+animal4)
    print("Interesting Animal Facts about new animal:")
    print(generate_description(animal4))
    print(animals)
    time.sleep(5)

import openai
import random

OPENAI_API_KEY = "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"
openai.api_key = OPENAI_API_KEY

animals = {} #read file on load --> add both formatted and unformatted animals
formatted_animals = []
unformatted_animals = []

def set_animal(formatted_string, unformatted_string):
    if formatted_string != None:
        formatted_animals = formatted_string.split("||")
        unformatted_animals = unformatted_string.split(" ")
        for i, animal in enumerate(formatted_animals):
            pars = animal.split(" - ")
            values = dic[1].split(", ")
            animals[dic[0]] = values

def addAnimal(txt):
    txt = txt.replace("\n", "")
    formatted_animals.append(txt)
    txt = txt.replace("*", "")
    pars = txt.split(" - ")
    values = pars[1].split(", ")
    animals[pars[0]] = values
    animal_name = pars[0]
    unformatted_animals.append(animal_name)

def compareAnimals(animal_1, animal_2):
    an1 = animal_1
    an2 = animal_2

    all_traits = animals[an1] + animals[an2]

    traits = random.sample(all_traits, 2)

    prefix = random.choice(["ocean", "unique", "less known", "", ""])

    new_animal = openai.Completion.create(
        model="text-davinci-003",
        prompt="Name an "+prefix+" animal that has the personality traits: " + traits[0] + " and " + traits[1] +". The animal should not be in the list: "+" ".join(unformatted_animals)+". ",
        max_tokens=2048,
        temperature=0
    )
    txt = "*"+new_animal.choices[0].text+" - "+traits[0]+", "+traits[1]+"*"
    addAnimal(txt)

def generateAnimal():
    prefix = random.choice(["ocean", "unique", "less known", "", ""])

    response = openai.Completion.create(
        model="text-davinci-003",
        prompt="Provide a random "+prefix+" animal that is not any of the following: ["+" ".join(unformatted_animals)+"]. Provide two unique personality traits that are associated with the animal. Format response in the following way: *animal - first trait, second trait*. Include the asterics. Do not include periods.",
        max_tokens=2048,
        temperature=0
    )
    txt = response.choices[0].text
    addAnimal(txt)

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

def get_unformatted():
    return " ".join(unformatted_animals)

def get_formatted():
    return "||".join(formatted_animals)

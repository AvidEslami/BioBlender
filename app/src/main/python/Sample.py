import openai
import random
import json

OPENAI_API_KEY = "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"
openai.api_key = OPENAI_API_KEY

animals = {}

# def addAnimal():

def gen():
    response = openai.Completion.create(
        model="text-davinci-003",
        prompt="List 4 random animals and 2 of their associated personality traits. Begin each list element with a *. Type in one line. Separate list element by*",
        max_tokens=2048,
        temperature=0
    )
    return(response.choices[0].text)

    # animals = {}
    # current_list = ""
    #
    # ans = response.choices[0].text
    #
    # temp = ans.split("*")
    #
    # for i, animal in enumerate(temp):
    #     dic = animal.split(" - ")
    #     if len(dic) > 1:
    #         values = dic[1].split(", ")
    #         animals[dic[0]] = values
    #         current_list+=dic[0]+" "
    #
    # an1 = animals.keys()[0]
    # an2 = animals.keys()[1]
    #
    # all_traits = animals[an1] + animals[an2]
    #
    # traits = random.sample(all_traits, 2)
    #
    # print(traits)
    #
    # new_animal = openai.Completion.create(
    #     model="text-davinci-003",
    #     prompt="Name a animal that has the personality traits: " + traits[0] + " and " + traits[1] +" that is not in the list: "+current_list+". Explain why.",
    #     max_tokens=2048,
    #     temperature=0
    # )
    #
    # n_a = new_animal.choices[0].text
    #
    # animals[n_a] = [traits[0], traits[1]]
    # current_list+=n_a+" "
    #
    # return n_a

def test(asdf):
    return gen()

# if __name__ == __name__:
#     print(gen())
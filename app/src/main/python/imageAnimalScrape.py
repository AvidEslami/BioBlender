from serpapi import GoogleSearch

def serpapi_get_google_images(prompt):
    image_results = []
    params = {
            "engine": "google",               # search engine. Google, Bing, Yahoo, Naver, Baidu...
            "q": prompt + " animal",                       # search query
            "tbm": "isch",                    # image results
            "num": "2",                     # number of images per page
            "ijn": 0,                         # page number: 0 -> first page, 1 -> second...
            "api_key": "2d950eb06cd66ef283daead6f2ddaaa60569264160feb8e723dc2e8ae9907d96",                 # https://serpapi.com/manage-api-key
            # other query parameters: hl (lang), gl (country), etc
        }
    search = GoogleSearch(params)         # where data extraction happens

    images_is_present = True
    results = search.get_dict()
    for image in results["images_results"]:
        if image["original"] not in image_results:
            image_results.append(image["original"])
            # print(image_results)
            print(image_results[0])
            return(image_results[0])


from serpapi import GoogleSearch

def serpapi_get_google_images(prompt):
    image_results = []
    params = {
            "engine": "google",               # search engine. Google, Bing, Yahoo, Naver, Baidu...
            "q": prompt + " animal",                       # search query
            "tbm": "isch",                    # image results
            "num": "2",                     # number of images per page
            "ijn": 0,                         # page number: 0 -> first page, 1 -> second...
            "api_key": "79d8e223413a61a687dc2611c209c6bdbdc6b68be811cdb1313f272cab2de01a",                 # https://serpapi.com/manage-api-key
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


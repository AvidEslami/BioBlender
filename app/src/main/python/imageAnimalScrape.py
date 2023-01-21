from serpapi import GoogleSearch

def findImageAnimal(prompt):
    image_results = []
    params = {
            "engine": "google",               # search engine. Google, Bing, Yahoo, Naver, Baidu...
            "q": prompt,                       # search query
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
            return(image_results)


    # for query in ["snow leopard"]:
    #     # search query parameters
    #     params = {
    #         "engine": "google",               # search engine. Google, Bing, Yahoo, Naver, Baidu...
    #         "q": query,                       # search query
    #         "tbm": "isch",                    # image results
    #         "num": "2",                     # number of images per page
    #         "ijn": 0,                         # page number: 0 -> first page, 1 -> second...
    #         "api_key": "2d950eb06cd66ef283daead6f2ddaaa60569264160feb8e723dc2e8ae9907d96",                 # https://serpapi.com/manage-api-key
    #         # other query parameters: hl (lang), gl (country), etc  
    #     }
    
        # search = GoogleSearch(params)         # where data extraction happens
    
        # images_is_present = True
        # while images_is_present:
        #     results = search.get_dict()       # JSON -> Python dictionary
    
        #     # checks for "Google hasn't returned any results for this query."
        #     if "error" not in results:
        #         for image in results["images_results"]:
        #             if image["original"] not in image_results:
        #                 image_results.append(image["original"])
        #                 print(image_results)
        #                 images_is_present = False
        #                 break
                        
                
        #         # update to the next page
        #         params["ijn"] += 1
        #     else:
        #         print(results["error"])
        #         images_is_present = False
    
    # -----------------------
    # Downloading images

    # for index, image in enumerate(results["images_results"], start=1):
    #     print(f"Downloading {index} image...")
        
    #     opener=urllib.request.build_opener()
    #     opener.addheaders=[("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/103.0.5060.114 Safari/537.36")]
    #     urllib.request.install_opener(opener)

    #     urllib.request.urlretrieve(image["original"], f"SerpApi_Images/original_size_img_{index}.jpg")

    # print(json.dumps(image_results, indent=2))
    # print(len(image_results))

# # if __name__ == __name__:
# serpapi_get_google_images()
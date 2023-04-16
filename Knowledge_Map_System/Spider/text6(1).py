import requests
from lxml import etree

def check(a):
    a=a.replace('\r','')
    a=a.replace('\n','')
    a=a.replace('\t','')
    return a

fp1=open('python/pachong/data.txt','w+',encoding='utf-8')
fp2=open('python/pachong/output.txt','a+',encoding='utf-8')

def solve(num):
    url="https://webarchives.tnm.jp/imgsearch/search?"

    param={
        'invnum':'A-',
        'title':'',
        'creator':'',
        'excavation':'',
        'designation':'',
        'imageid1':'',
        'imageid2':'',
        'page':str(num),
    }
    
    headers={
        'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36 Edg/112.0.1722.34'
    }

    
    reponse=requests.get(url=url,params=param,headers=headers)
    reponse.encoding=reponse.apparent_encoding

    page_text=reponse.text
    tree=etree.HTML(page_text.encode('utf-8'))

    r=tree.xpath('/html/body//div[@class="container"]')

    for li in r:
        p1=li
        tool1=p1.xpath('./a/@href')[0]
        print('https://webarchives.tnm.jp/imgsearch/'+tool1,file=fp2,end=',')
        tool1=p1.xpath('./a/img/@class')[0]
        print(tool1,file=fp2,end=',')
        tool1=p1.xpath('./a/img/@title')[0]
        print(tool1,file=fp2,end=',')
        tool1=p1.xpath('./a/img/@src')[0]
        print(tool1,file=fp2,end=',')

        tool1=p1.xpath('./div//text()')
        for row in tool1:
            a=check(row)
            if(a!=''):
                print(check(row),file=fp2,end=',')


        print("",file=fp2)

for i in range(1,532):
 solve(i)
 print(i)

fp1.close()
fp2.close()








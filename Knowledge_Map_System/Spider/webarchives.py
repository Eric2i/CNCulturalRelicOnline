import requests
from lxml import etree

def check(a):
    a=a.replace('\r','')
    a=a.replace('\n','')
    a=a.replace('\t','')
    return a

fp1=open('python/pachong/data.txt','w+',encoding='utf-8')
fp2=open('python/pachong/output.txt','a+',encoding='utf-8')
headers={
        'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36 Edg/112.0.1722.34'
    }

def check_solve(url):
    reponse=requests.get(url=url,headers=headers)
    reponse.encoding=reponse.apparent_encoding
    tree=etree.HTML(reponse.text.encode('utf-8'))
    r=tree.xpath('/html/body/div[@id="wrapper"]/table[@id="container"]//td[@id="info"]/table//td/text()')
    i=0
    for li in r:
        p1=li
        p1=check(p1)
        if(p1!=''):
            print(p1,file=fp2,end='')
        if(i%2==1):
            print(',',end='',file=fp2)
        i+=1
    


def solve(num):
    url="https://webarchives.tnm.jp/imgsearch/search?"
    param={
        'q':'中国',
        'page':str(num),
    }
    
    reponse=requests.get(url=url,params=param,headers=headers)
    reponse.encoding=reponse.apparent_encoding

    page_text=reponse.text
    print(page_text,file=fp1)
    tree=etree.HTML(page_text.encode('utf-8'))

    r=tree.xpath('/html/body//div[@class="container"]')

    for li in r:
        p1=li
        
        tool1=p1.xpath('./a/img/@class')[0]
        #print(tool1,file=fp2,end=',')
        tool1=p1.xpath('./a/img/@title')[0]
        print('名称:'+tool1,file=fp2,end=',')
        
        tool1=p1.xpath('./a/@href')[0]
        check_solve('https://webarchives.tnm.jp/imgsearch/'+tool1)
            
        tool1=p1.xpath('./a/img/@src')[0]
        tool1=tool1.replace("thumb",'1024')
        print(tool1,file=fp2,end=',')

        print("",file=fp2)


for i in range(1,89):
 solve(i)
 print(i)
fp1.close()
fp2.close()








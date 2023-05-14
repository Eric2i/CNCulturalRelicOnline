import requests
from lxml import etree
from functools import partial

def check(a):
    a=a.replace('\r','')
    a=a.replace('\n','')
    a=a.replace('\t','')
    str=' '.join(a.split())
    return str
dict={
    'Name:':0,
    'Date:':1,
    'Palace:':2,
    'Type:':3,
    'Medium and Support:':4,
    'Credit Line:':5,
    'Accession Number:':6,
    'State/Province:':7,
    'Dimensions:':8,
    'Href:':9
}

headers={
        'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36 Edg/112.0.1722.68',
        'Cookie':'_gid=GA1.2.1379155766.1683204964; per_page=25; sort_order=asc; sort_by=relevance; ci_session=a:6:{s:10:"session_id";s:32:"dd6aec738767f82bee3dcb53974cf179";s:10:"ip_address";s:14:"192.168.201.48";s:10:"user_agent";s:50:"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWeb";s:13:"last_activity";i:1683251556;s:9:"user_data";s:0:"";s:17:"collection_search";a:1:{s:10:"everywhere";s:5:"china";}}1da36aa6243017636de9759535821aa9; _gat=1; _ga_PRR0QFPZ0S=GS1.1.1683250838.3.1.1683251638.0.0.0; _ga=GA1.1.757070965.1683204964; __atuvc=66|18; __atuvs=64545e96c47dcab700c'
}

reponse=requests.get(url=url,headers=headers)
 
def solve12(url):
    fp2=open('python/pachong3/now/output.txt','a+',encoding='utf-8')
    url_common='https://collection.sdmart.org'
    reponse=requests.get(url=url,headers=headers)
    reponse.encoding=reponse.apparent_encoding
    page_text=reponse.text
    tree=etree.HTML(page_text.encode('utf-8'))
    r=tree.xpath('/html/body//div[@style="position: relative;"]')
    p0=r[0].xpath('./div[@class="container"]//div[@class="row"]//a/@href')
    p1=r[0].xpath('./div[@class="container"]//div[@class="col"]')

    p11=p1[0].xpath('./h4/text()')
    p12=p1[0].xpath('./div[1]/text()')
    p13=p1[0].xpath('./div[2]/text()')

    arr = ['','','','','','','','','','']
    arr[0]=check(p11[0])
    arr[1]=check(p12[1])
    arr[2]=check(p13[1])

    p2=p1[0].xpath('./div[@id="accordion"]//div[@class="content col-md-12"]/div')
    for ip in p2:
        p22=ip.xpath('./strong/text()')
        if(len(p22)<1):
            continue
        p23=ip.xpath('./text()')
        str=''
        for it in p23:
            a=check(it)
            if(len(a)>0):
                str=str+a
        flag=dict.get(p22[0],-1)
        if(flag!=-1):
            arr[flag]=str
    
    arr[9]=url_common+p0[0]
    for i  in range(0,9):
        print(arr[i],end='!',file=fp2)
    print(arr[9],file=fp2)



def solve(num):
    url="https://collection.sdmart.org/objects-1/portfolio?records=50&query=Creation_Place2%20has%20words%20%22china%22&sort=9&page="
    url_common='https://collection.sdmart.org'
    url=url+str(num)
    print(url)
    
    reponse=requests.get(url=url,headers=headers)
    reponse.encoding=reponse.apparent_encoding

    page_text=reponse.text
    tree=etree.HTML(page_text.encode('utf-8'))
    r=tree.xpath('/html/body//div[@style="position: relative;"]/div/div/div')

    tool=len(r)
    for i in range(0,tool):
        p1=r[i].xpath('./div/div[@class="card-img-top"]/a/@href')
        solve12(url_common+p1[0])
        print(i,end=' ')

for i in range(0,43):
    solve(i)
    print()





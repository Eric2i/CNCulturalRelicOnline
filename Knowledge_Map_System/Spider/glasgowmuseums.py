import requests
from lxml import etree

def check(a):
    a=a.replace('\r','')
    a=a.replace('\n','')
    a=a.replace('\t','')
    return a

fp1=open('python/pachong2/data.txt','w+',encoding='utf-8')
fp2=open('python/pachong2/output.txt','a+',encoding='utf-8')

headers={
        'Cookie':'_gid=GA1.2.687696881.1683207967; user=1683207999028533; realname=; permissions=33660111080401020603; screen=1707; imagedata=; title=; dtype=d; srsize=16; save=; frame=1635; count=3699; keyword=china; bhp=1; lastrequest=AS; query=request=advanced;dtype=d;_tkeyword=china; fvset=false; sorted=0; startat=1; _ga=GA1.2.1899453296.1683207967; lastdisp=request=jump;dtype=d;startat=1|request=advanced;dtype=d;_tkeyword=china; _ga_GM5GHMZ09G=GS1.1.1683207967.1.1.1683208351.0.0.0',
        'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/112.0.0.0 Safari/537.36 Edg/112.0.1722.34'
    }
url_next="http://collections.glasgowmuseums.com/mwebcgi/mweb"
url_src="http://collections.glasgowmuseums.com"

def solve(num):
    fp2=open('python/pachong2/output.txt','a+',encoding='utf-8')
    url="http://collections.glasgowmuseums.com/mwebcgi/mweb?request=jump;dtype=d;startat="
    num=(num-1)*16+1
    url=url+str(num)
    print(url)
    
    reponse=requests.get(url=url,headers=headers)
    reponse.encoding=reponse.apparent_encoding

    page_text=reponse.text
    #print(page_text,file=fp1)
    tree=etree.HTML(page_text.encode('utf-8'))
    img=tree.xpath('/html/body/main//div[@class="searchResultsRowImage"]/a[@class="floatLeftNoPad"]/img/@src')
    r=tree.xpath('/html/body/main//div[@class="searchResultsRowInner"]')
    tool=len(r)
    for i in range(0,tool):
        p1=r[i].xpath('./div[2]/b/a/text()')
        tool1=""
        tool2=""
        tool3=""
        tool4=""
        if(len(p1)>0):
            tool1=p1[0]
        p2=(r[i].xpath('./div[4]/text()'))
        if(len(p2)>0):
            tool2=p2[0]
        p3=(r[i].xpath('./div[5]/text()'))
        if(len(p3)>0):
            tool3=p3[0]
        p4=(r[i].xpath('./div[6]/text()'))
        if(len(p4)>0):
            tool4=p4[0]
        tool5=url_src+img[i]
        print(tool1+',=,'+tool2+",=,"+tool3+",=,"+tool4+",=,"+tool5,file=fp2)

for i in range(166,233):
    solve(i)
    print(i)





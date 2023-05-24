package com.ruoyi.system.controller;

import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Pic;
import com.ruoyi.system.service.IPicService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片信息Controller
 *
 * @author ruoyi
 * @date 2023-05-07
 */
@RestController
@RequestMapping("/system/pic")
public class PicController extends BaseController
{
    @Autowired
    private IPicService picService;

    /**
     * 查询图片信息列表
     */
    //@PreAuthorize("@ss.hasPermi('system:pic:list')")
    @GetMapping("/list")
    public TableDataInfo list(Pic pic)
    {
        startPage();
        List<Pic> list = picService.selectPicList(pic);
        return getDataTable(list);
    }

    /**
     * 导出图片信息列表
     */
    //@PreAuthorize("@ss.hasPermi('system:pic:export')")
    @Log(title = "图片信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Pic pic)
    {
        List<Pic> list = picService.selectPicList(pic);
        ExcelUtil<Pic> util = new ExcelUtil<Pic>(Pic.class);
        util.exportExcel(response, list, "图片信息数据");
    }

    /**
     * 获取图片信息详细信息
     */
    //@PreAuthorize("@ss.hasPermi('system:pic:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(picService.selectPicById(id));
    }

    /**
     * 新增图片信息
     */
    @Log(title = "图片信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Pic pic)
    {
        return toAjax(picService.save(pic));
    }

    /**
     * 修改图片信息
     */
    //@PreAuthorize("@ss.hasPermi('system:pic:edit')")
    @Log(title = "图片信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Pic pic)
    {
        return toAjax(picService.updateById(pic));
    }

    @DeleteMapping("/deleteBy")
    public AjaxResult deleteBy(@RequestBody Pic pic) {
        return toAjax(picService.deleteBy(pic));
    }

    /**
     * 删除图片信息
     */
    //@PreAuthorize("@ss.hasPermi('system:pic:remove')")
    @Log(title = "图片信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(picService.removeByIds(Arrays.asList(ids)));
    }
}

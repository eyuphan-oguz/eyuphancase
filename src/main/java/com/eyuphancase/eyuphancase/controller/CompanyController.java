package com.eyuphancase.eyuphancase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eyuphancase.eyuphancase.model.vm.Company.AddCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.DeleteCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.GetAllCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.GetCompanyVm;
import com.eyuphancase.eyuphancase.model.vm.Company.UpdateCompanyVm;
import com.eyuphancase.eyuphancase.service.CompanyService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/companies")
@Tag(name = "Şirket İşlemleri")
@SecurityRequirement(name = "company")
public class CompanyController {

    CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Operation(
        description = "Bu metod, sistemde bulunan tüm şirketleri listelemek için kullanılır.",
        summary =   "Bu metod tüm şirketleri listeler.",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @GetMapping()
    public ResponseEntity<List<GetAllCompanyVm>> getAllCompanyVm(){
        List<GetAllCompanyVm> getAllCompanyVm = companyService.getAllCompanyVm();
        return ResponseEntity.ok(getAllCompanyVm);
    }

    @Operation(
        description = "Bu metod, belirli bir şirkete ait verileri listelemek için kullanılır. {id} parametresi, istenen şirketin benzersiz tanımlayıcısını belirtir. API'ye gönderilen bu {id} parametresi sayesinde, ilgili şirkete ait olan Şirketler filtrelenir ve listelenir.",
        summary =   "Bu metod, {id} parametresi gönderilen belirtilen şirketleri listelemek için kullanılır.",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @GetMapping("/{id}")
    public ResponseEntity<GetCompanyVm> getCompanyVm(@PathVariable  Long id){
        GetCompanyVm getCompanyVm = companyService.getCompanyVm(id);
        return ResponseEntity.ok(getCompanyVm);
    }


    @Operation(
        description = "Bu metod, yeni şirket eklemesi için kullanılır. Yeni bir şirket eklemek isteyen, bu metod aracılığıyla gerekli bilgileri sisteme iletebilir.",
        summary =   "Bu metod, yeni şirket eklenmesine izin verir.",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @PostMapping
    public ResponseEntity<AddCompanyVm> addCompanyVm(@RequestBody @Valid AddCompanyVm addCompanyVm){
        AddCompanyVm addCompanyVm2 = companyService.addCompanyVm(addCompanyVm);
        return ResponseEntity.status(HttpStatus.CREATED).body(addCompanyVm2);
    }

    @Operation(
        description = "Bu metod, \"id\" şirketine göre silme işlemi gerçekleştirmesi için kullanılır.",
        summary =   "Bu metod, belirtilen şirketi silmesine izin verir. ",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteCompanyVm> deleteCompanyVm(@PathVariable Long id){
        DeleteCompanyVm deleteCompanyVm = companyService.deleteCompanyVm(id);
        return ResponseEntity.ok(deleteCompanyVm);
    }

    @Operation(
        description = "Bu metod, \"id\" şirketine göre güncelleme işlemi gerçekleştirmesi için kullanılır.",
        summary =   "Bu metod, belirtilen şirketi güncellemesine izin verir. ",
        responses = {
            @ApiResponse(
                description = "Başarılı",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Geçersiz istek",
                responseCode = "400"
            ),
            @ApiResponse(
                description = "Yetkisiz işlem",
                responseCode = "403"
            ),
            @ApiResponse(
                description = "Bulunamadı",
                responseCode = "404"
            )
        }
    )
    @PutMapping("/{id}")
    public ResponseEntity<UpdateCompanyVm> updateCompanyVm(@PathVariable Long id,@RequestBody @Valid UpdateCompanyVm updateCompanyVm){
        UpdateCompanyVm updateCompanyVm2 = companyService.updateCompanyVm(id,updateCompanyVm);
        return ResponseEntity.ok(updateCompanyVm2);
    }
    
}

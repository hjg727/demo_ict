package demo_ict.demo_ict.controller;

import demo_ict.demo_ict.entity.Member;
import demo_ict.demo_ict.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
//@CrossOrigin(origins = "요청받을url")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Long> createMember(@RequestBody Member member){
        Long id = memberService.join(member);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers(){
        List<Member> members = memberService.findMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMember(@PathVariable Long id){
        Member member = memberService.findOne(id);
        return ResponseEntity.ok(member);
    }
}